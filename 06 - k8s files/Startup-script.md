# Set up and deploy the microservices using Kubernetes on a linux server

## Step 1 - Install and configure Kubernetes:


Install Snap
```
sudo wget -O /etc/yum.repos.d/snapd.repo https://bboozzoo.github.io/snapd-amazon-linux/al2023/snapd.repo
sudo dnf install snapd -y
```

Install microk8s

```
sudo snap install microk8s --classic --channel=1.33
```
*Note - if you get a message saying "error: too early for operation, device not yet seeded or device model not acknowledged", wait a few seconds and try again.*

Configure Kubernetes
```
sudo usermod -a -G microk8s $USER
mkdir -p ~/.kube
chmod 0700 ~/.kube
su - $USER
```
you might be asked to enter the login password at this point.
```
microk8s status --wait-ready

microk8s kubectl get nodes

echo "alias kubectl='microk8s kubectl'" >> ~/.bashrc && source ~/.bashrc
```


Enable the local registry
```
microk8s enable registry
tee /etc/docker/daemon.json > /dev/null <<EOF
{
  "insecure-registries" : ["localhost:32000"]
}
EOF
sudo systemctl restart docker
```

Enable Ingress and loadbalancing
```
microk8s enable ingress
microk8s enable metallb:10.64.140.43-10.64.140.49
```


## Step 2 - clone the repo
```
git clone https://github.com/vppmatt/microservices-bam.git
cd microservices-bam/06\ -\ k8s\ files/
```

## Step 3 - build and run the database

Navigate into the folder and build the docker image
```
cd database
docker build -t localhost:32000/bam-db:1.0 --build-arg DBPASSWORD=pass123! .
```

Push the docker image to the Kubernetes repository
```
docker push localhost:32000/bam-db:1.0
```

Deploy the application
```
kubectl apply -f deploy.yaml
```

Wait for the pod to become ready / watch the logs:
```
watch microk8s kubectl get po
```
and/or
```
kubectl logs -f deploy/bam-db
```

## Step 4 - build and run the messaging server
```
cd ..
cd activeMQ/
docker build -t localhost:32000/bam-activemq:1.0 .
docker push localhost:32000/bam-activemq:1.0
kubectl apply -f deploy.yaml
```


Wait for the pod to become ready / watch the logs:
```
watch microk8s kubectl get po
```
and/or
```
kubectl logs -f deploy/bam-activemq
```

## Step 5 - build and run the api gateway
```
cd ..
cd apigateway/
chmod a+x mvnw
./mvnw package
docker build -t localhost:32000/bam-apigateway:1.0 .
docker push localhost:32000/bam-apigateway:1.0
kubectl apply -f deploy.yaml
```

Because this needs to be visible outside the cluster we can first port forward and then test it with:
```
kubectl port-forward svc/bam-apigateway 8100:8080 --address 0.0.0.0 &
curl -i localhost:8100/healthz
```

Now you can visit the url in your browser (http://your-server-name:8100/healthz)

Note: this sets port forwarding to work in the background. To stop it, run the command `jobs` to get the id of the job and then `fg 1` for job number 1 to bring it into the foreground. You can then press ctrl+c to stop the job running. 

## Step 6 - build and run the user manager
```
cd ..
cd usermanager
chmod a+x mvnw
./mvnw package
docker build -t localhost:32000/bam-user:1.0 --build-arg DBPASSWORD=pass123! .
docker push localhost:32000/bam-user:1.0 
kubectl apply -f deploy.yaml
```

## Step 7 - build and run the building manager
```
cd ..
cd buildingmanager
chmod a+x mvnw
./mvnw package
docker build -t localhost:32000/bam-building:1.0 --build-arg DBPASSWORD=pass123! .
docker push localhost:32000/bam-building:1.0 
kubectl apply -f deploy.yaml
```

# Step 8 - build and run the front end

```
cd ..
cd bam-ui
nvm install node
npm install
```

Next we need to edit the files in the `src/data` folder to set the URL of the api gateway.

```
grep -rl "http://localhost:8080" src/data | xargs sed -i "s#http://localhost:8080#http://$(curl -s ifconfig.me):8100#g"
```

Now we can continue the build process:
```
npm run build
docker build -t localhost:32000/bam-ui:1.0  .
docker push localhost:32000/bam-ui:1.0
kubectl apply -f deploy.yaml
```

Because this needs to be visible outside the cluster we can first port forward and then test it with:
```
kubectl port-forward svc/bam-ui 8081:80 --address 0.0.0.0 &
curl -i localhost:8081
```

Now you can visit the url in your browser (http://your-server-name:80/healthz)

Note: this sets port forwarding to work in the background. To stop it, run the command `jobs` to get the id of the job and then `fg 1` for job number 1 to bring it into the foreground. You can then press ctrl+c to stop the job running. 

## Step 9 - expose the UI and Api Gateway

```
cd ..
cd ingress
kubectl apply -f ingress.yaml
```

## Step 10 - test
Visit the url - we have exposed port 8100, so if your server is server1.neueda.com, then visit:

http://server1.neueda.com:8100
