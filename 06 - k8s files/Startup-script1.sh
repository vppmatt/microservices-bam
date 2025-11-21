#!/bin/bash
set -e

reg_name='kind-registry'
reg_port='5001'
REGISTRY_HOST="localhost:${reg_port}"

echo "Using local registry host: ${REGISTRY_HOST}"

############################
# 1. Configure Docker daemon
############################

DOCKER_DIR="/etc/docker"
DAEMON_FILE="${DOCKER_DIR}/daemon.json"

echo "Configuring Docker to trust insecure registry: ${REGISTRY_HOST}"
sudo mkdir -p "${DOCKER_DIR}"

sudo bash -c "cat > '${DAEMON_FILE}' <<EOF
{
  \"insecure-registries\": [
    \"${REGISTRY_HOST}\"
  ]
}
EOF"

echo "Restarting Docker..."
if command -v systemctl >/dev/null 2>&1; then
    sudo systemctl restart docker
else
    sudo service docker restart
fi
echo "Docker has been configured for insecure registry: ${REGISTRY_HOST}"

#########################
# 2. Install kind & kubectl
#########################

# install Kubernetes (Kind)
if [ ! -x /usr/local/bin/kind ]; then
  [ \"$(uname -m)\" = x86_64 ] && curl -Lo ./kind https://kind.sigs.k8s.io/dl/v0.30.0/kind-linux-amd64
  chmod +x ./kind
  sudo mv ./kind /usr/local/bin/kind
fi

# install kubectl
if ! command -v kubectl >/dev/null 2>&1; then
  curl -LO "https://dl.k8s.io/release/\$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
  sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
fi

###########################################
# 3. Start the local registry (kind-registry)
###########################################

if [ "\$(docker inspect -f '{{.State.Running}}' \"${reg_name}\" 2>/dev/null || true)" != 'true' ]; then
  echo \"Starting local registry container ${reg_name} on ${REGISTRY_HOST}...\"
  docker run \
    -d --restart=always \
    -p "127.0.0.1:${reg_port}:5000" \
    --network bridge \
    --name "${reg_name}" \
    registry:2
else
  echo \"Registry container ${reg_name} already running\"
fi

###########################################
# 4. Create the kind cluster (official pattern)
###########################################

echo \"Creating kind cluster with local registry support...\"

cat <<EOF | kind create cluster --config=-
kind: Cluster
apiVersion: kind.x-k8s.io/v1alpha4
containerdConfigPatches:
- |-
  [plugins."io.containerd.grpc.v1.cri".registry]
    config_path = "/etc/containerd/certs.d"
EOF

###########################################
# 5. Add registry config to each kind node
###########################################

# This matches the official kind local-registry setup:
# containerd will map localhost:${reg_port} to kind-registry:5000 over HTTP.
REGISTRY_DIR="/etc/containerd/certs.d/localhost:${reg_port}"
for node in $(kind get nodes); do
  echo \"Configuring containerd on node ${node} for ${REGISTRY_HOST}...\"
  docker exec "${node}" mkdir -p "${REGISTRY_DIR}"
  cat <<EOF | docker exec -i "${node}" cp /dev/stdin "${REGISTRY_DIR}/hosts.toml"
[host."http://${reg_name}:5000"]
EOF
done

###################################################
# 6. Connect the registry to the kind network if needed
###################################################

if [ "$(docker inspect -f='{{json .NetworkSettings.Networks.kind}}' \"${reg_name}\")" = 'null' ]; then
  echo \"Connecting ${reg_name} to kind network...\"
  docker network connect "kind" "${reg_name}"
fi

###########################################
# 7. Document the local registry in Kubernetes
###########################################

cat <<EOF | kubectl apply -f -
apiVersion: v1
kind: ConfigMap
metadata:
  name: local-registry-hosting
  namespace: kube-public
data:
  localRegistryHosting.v1: |
    host: "${REGISTRY_HOST}"
    help: "https://kind.sigs.k8s.io/docs/user/local-registry/"
EOF

echo "Kind cluster and local registry are ready. Use images like: ${REGISTRY_HOST}/your-image:tag"
