FROM openjdk:16
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} addressservice.jar
ENTRYPOINT ["java","-jar","/addressservice.jar"]