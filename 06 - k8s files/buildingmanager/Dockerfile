FROM amazoncorretto:17
ADD target/buildingmanager-0.0.1-SNAPSHOT.jar building.jar

ARG DBPASSWORD
ENV DBPASSWORD=$DBPASSWORD

ARG DBHOSTNAME
ENV DBHOSTNAME=$DBHOSTNAME

CMD ["java", "-jar","-Dspring.profiles.active=production", "building.jar"]