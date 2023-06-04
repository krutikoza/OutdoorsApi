FROM openjdk:11
EXPOSE 8080
ADD target/OutdoorsApi.jar OutdoorsApi.jar
ENTRYPOINT ["java","-jar","OutdoorsApi.jar"]
