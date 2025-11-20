reg_name='kind-registry'
reg_port='5001'
HOSTNAME_VALUE="$(hostname)"
REGISTRY_HOST="${HOSTNAME_VALUE}:5001"

#install Kubernetes (Kind)
[ $(uname -m) = x86_64 ] && curl -Lo ./kind https://kind.sigs.k8s.io/dl/v0.30.0/kind-linux-amd64
chmod +x ./kind
sudo mv ./kind /usr/local/bin/kind

#install kubectl
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"

sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl

#set up a local registry
docker run -d --restart=always -p "${reg_port}:5000" --name "${reg_name}" registry:2

echo "Creating kind cluster with registry host: ${REGISTRY_HOST}"

cat <<EOF | kind create cluster --config=-
kind: Cluster
apiVersion: kind.x-k8s.io/v1alpha4

containerdConfigPatches:
# Keep the existing certs.d config path
- |-
  [plugins."io.containerd.grpc.v1.cri".registry]
    config_path = "/etc/containerd/certs.d"

# Add HTTP registry override dynamically
- |-
  [plugins."io.containerd.grpc.v1.cri".registry.mirrors]
    [plugins."io.containerd.grpc.v1.cri".registry.mirrors."${REGISTRY_HOST}"]
      endpoint = ["http://${REGISTRY_HOST}"]
EOF

#Add the registry config to the nodes

REGISTRY_DIR="/etc/containerd/certs.d/${REGISTRY_HOST}"
for node in $(kind get nodes); do
  docker exec "${node}" mkdir -p "${REGISTRY_DIR}"
  cat <<EOF | docker exec -i "${node}" cp /dev/stdin "${REGISTRY_DIR}/hosts.toml"
[host."http://${reg_name}:5000"]
EOF
done


# Connect the registry to the cluster network if not already connected
if [ "$(docker inspect -f='{{json .NetworkSettings.Networks.kind}}' kind-registry)" = 'null' ]; then
  docker network connect "kind" kind-registry
fi

# Document the local registry
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

# Make docker use http rather than https to access the registry
set -e
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

# Restart Docker service
if command -v systemctl >/dev/null 2>&1; then
    sudo systemctl restart docker
else
    sudo service docker restart
fi

echo "Docker has been configured for insecure registry: ${REGISTRY_HOST}"