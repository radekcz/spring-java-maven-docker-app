FROM amazoncorretto:17

RUN mkdir /app
COPY ./core/target/*.jar /app/spring-maven-docker-base.jar

ENTRYPOINT ["java", "-jar", "/app/spring-maven-docker-base.jar"]