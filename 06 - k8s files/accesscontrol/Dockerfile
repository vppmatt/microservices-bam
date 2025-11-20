FROM amazoncorretto:17
ADD target/accesscontrol-0.0.1-SNAPSHOT.jar accesscontrol.jar

ARG DBPASSWORD
ENV DBPASSWORD=$DBPASSWORD

ARG DBHOSTNAME
ENV DBHOSTNAME=$DBHOSTNAME

CMD ["java", "-jar","-Dspring.profiles.active=production",  "accesscontrol.jar"]