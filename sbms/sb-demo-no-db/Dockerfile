FROM eclipse-temurin:21-jdk
LABEL maintainer ="kamal"
WORKDIR /myapp-dir
COPY ./build/libs/sb-demo-no-db-0.0.1-SNAPSHOT.jar sb-demo-no-db-0.0.1-SNAPSHOT.jar
EXPOSE 9000
CMD [ "java", "-jar", "sb-demo-no-db-0.0.1-SNAPSHOT.jar" ]