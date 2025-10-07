microk8s status --wait-ready
microk8s kubectl get nodes

echo "alias kubectl='microk8s kubectl'" >> ~/.bashrc && source ~/.bashrc


microk8s enable registry
tee /etc/docker/daemon.json > /dev/null <<EOF
{
  "insecure-registries" : ["localhost:32000"]
}
EOF
sudo systemctl restart docker


cd microservices-bam/06\ -\ k8s\ files/

cd database
docker build -t localhost:32000/bam-db:1.0 --build-arg DBPASSWORD=pass123! .
docker push localhost:32000/bam-db:1.0
microk8s kubectl apply -f deploy.yaml

cd ..
cd activeMQ/
docker build -t localhost:32000/bam-activemq:1.0 .
docker push localhost:32000/bam-activemq:1.0
microk8s kubectl apply -f deploy.yaml

cd ..
cd apigateway/
chmod a+x mvnw
./mvnw package
docker build -t localhost:32000/bam-apigateway:1.0 .
docker push localhost:32000/bam-apigateway:1.0
microk8s kubectl apply -f deploy.yaml

cd ..
cd usermanager
chmod a+x mvnw
./mvnw package
docker build -t localhost:32000/bam-user:1.0 --build-arg DBPASSWORD=pass123! .
docker push localhost:32000/bam-user:1.0 
microk8s kubectl apply -f deploy.yaml

cd ..
cd buildingmanager
chmod a+x mvnw
./mvnw package
docker build -t localhost:32000/bam-building:1.0 --build-arg DBPASSWORD=pass123! .
docker push localhost:32000/bam-building:1.0 
microk8s kubectl apply -f deploy.yaml

cd ..
cd accesscontrol
chmod a+x mvnw
./mvnw package
docker build -t localhost:32000/bam-access:1.0 --build-arg DBPASSWORD=pass123! .
docker push localhost:32000/bam-access:1.0 
microk8s kubectl apply -f deploy.yaml

cd ..
cd bam-ui
nvm install node
npm install

grep -rl "http://localhost:8080" src/data | xargs sed -i "s#http://localhost:8080#http://$(curl -s ifconfig.me):8100#g"

npm run build
docker build -t localhost:32000/bam-ui:1.0  .
docker push localhost:32000/bam-ui:1.0
microk8s kubectl apply -f deploy.yaml

microk8s kubectl port-forward svc/bam-ui 8081:80 --address 0.0.0.0 &
microk8s kubectl port-forward svc/bam-apigateway 8100:8080 --address 0.0.0.0 &

echo "Setup complete"