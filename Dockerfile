FROM amazoncorretto:17

LABEL mentainer="dockerfileNasti.nasti@gmail.com"

WORKDIR /app

COPY target/spring-1.0.jar /app/spring-1.0.jar

ENTRYPOINT ["java", "-jar", "spring-1.0.jar"]
