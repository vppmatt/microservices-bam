FROM amazoncorretto:17
ADD target/buildingmanager-0.0.1-SNAPSHOT.jar building.jar

ARG DBUSER
ENV DBUSER=$DBUSER

ARG DBPASSWORD
ENV DBPASSWORD=$DBPASSWORD

CMD ["java", "-jar","-Dspring.profiles.active=production", "building.jar"]