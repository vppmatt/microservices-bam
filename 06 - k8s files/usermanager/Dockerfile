FROM amazoncorretto:17
ADD target/usermanager-0.0.1-SNAPSHOT.jar user.jar

ARG DBPASSWORD
ENV DBPASSWORD=$DBPASSWORD

ARG DBHOSTNAME
ENV DBHOSTNAME=$DBHOSTNAME

CMD ["java", "-jar", "-Dspring.profiles.active=production","user.jar"]