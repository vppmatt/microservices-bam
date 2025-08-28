# Deploy the microservices on a linux server

## Step 1 - Spin up a MySQL instance

```
docker run -d -p3306:3306 -e MYSQL_ROOT_PASSWORD=n3u3da! mysql:5.7
```

check you can access it with `mysql -uroot -pn3u3da! -h127.0.0.1`

## Step 2 - clone the repo
```
git clone https://github.com/vppmatt/microservices-bam.git
cd microservices-bam/03\ -\ docker\ versions/
```

## Step 3 - build and run the database
```
cd database
docker build -t bam-db:1.0 --build-arg DBPASSWORD=n3u3da! .
docker network create bam
docker run -d --name bam-db --network bam bam-db:1.0
```

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
