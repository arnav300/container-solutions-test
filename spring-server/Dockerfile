#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#ARG JAR_FILE
#COPY ${JAR_FILE} swagger-spring-1.0.0.jar
#ENTRYPOINT ["java","-jar","/swagger-spring-1.0.0.jar"]

FROM openjdk:8
ADD target/swagger-spring-1.0.0.jar swagger-spring-1.0.0.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom -Djava.net.preferIPv4Stack=true", "-jar","swagger-spring-1.0.0.jar"]