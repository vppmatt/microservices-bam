FROM amazoncorretto:17
ADD target/accesscontrol-0.0.1-SNAPSHOT.jar accesscontrol.jar


ARG DBUSER
ENV DBUSER=$DBUSER

ARG DBPASSWORD
ENV DBPASSWORD=$DBPASSWORD

CMD ["java", "-jar","-Dspring.profiles.active=production",  "accesscontrol.jar"]