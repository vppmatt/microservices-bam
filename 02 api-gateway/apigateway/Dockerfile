FROM amazoncorretto:11
RUN mkdir /opt/app
COPY target/apigateway-0.0.1-SNAPSHOT.jar /opt/app/apigateway.jar
CMD ["java", "-jar", "/opt/app/apigateway.jar"]