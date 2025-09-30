# Set up and deploy the microservices using Kubernetes on a linux server

## Step 1 - Install and configure Kubernetes:

First make yourself a super-user
```
sudo su
```

Install Snap
```
wget -O /etc/yum.repos.d/snapd.repo https://bboozzoo.github.io/snapd-amazon-linux/al2023/snapd.repo
dnf install snapd -y
```

Install microk8s

```
sudo snap install microk8s --classic --channel=1.33
```

Configure Kubernetes
```
usermod -a -G microk8s $USER
mkdir -p ~/.kube
chmod 0700 ~/.kube
su - $USER
microk8s status --wait-ready

microk8s kubectl get nodes
alias kubectl='microk8s kubectl'
```


Enable the local registry
```
microk8s enable registry
tee /etc/docker/daemon.json > /dev/null <<EOF
{
  "insecure-registries" : ["localhost:32000"]
}
EOF
systemctl restart docker
```


## Step 2 - clone the repo
```
git clone https://github.com/vppmatt/microservices-bam.git
cd 06\ -\ k8s\ files/
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

Watch the logs / wait for the pod to become ready:
```
kubectl logs -f deploy/bam-db
```
and/or
```
watch kubectl get po
```

****TO HERE****

## Step 4 - build and run the messaging server
```
cd ..
cd activeMQ/
docker build -t bam-activemq:1.0 .
docker run -d --name bam-activemq --network bam bam-activemq:1.0
```

## Step 5 - build and run the api gateway
```
cd ..
cd apigateway/
chmod a+x mvnw
./mvnw package
docker build -t bam-apigateway:1.0 .
docker run -d --name bam-apigateway -p8081:8080  --network bam bam-apigateway:1.0
```

## Step 6 - build and run the user manager
```
cd ..
cd usermanager
chmod a+x mvnw
./mvnw package
docker build -t bam-user:1.0 --build-arg DBPASSWORD=n3u3da! .
docker run -d --name bam-user --network bam bam-user:1.0
```

## Step 7 - build and run the building manager
```
cd ..
cd buildingmanager
chmod a+x mvnw
./mvnw package
docker build -t bam-building:1.0 --build-arg DBPASSWORD=n3u3da! .
docker run -d --name bam-building --network bam bam-building:1.0
```

# Step 8 - build and run the access control server
```
cd ..
cd accesscontrol
chmod a+x mvnw
./mvnw package
docker build -t bam-access:1.0 --build-arg DBPASSWORD=n3u3da! .
docker run -d --name bam-access --network bam bam-access:1.0
```

# Step 9 - build and run the front end

```
cd ..
nvm install node
npm install
```

Next we need to edit the files in the `src/data` folder to set the URL of the api gateway. For example if your linux server is called server1.neueda.com, set this line in each of the files:

`const serverUrl = "http://server1.neueda.com:8081"`

Then we can continue the process:
```
npm run build
docker build -t bam-ui:1.0  .
docker run -d --name bam-ui --network bam -p8100:80 bam-ui:1.0
```

## Step 10 - test
Visit the url - we have exposed port 8100, so if your server is server1.neueda.com, then visit:

http://server1.neueda.com:8100
