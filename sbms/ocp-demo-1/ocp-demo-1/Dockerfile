FROM eclipse-temurin:21-jdk
LABEL maintainer ="kamal"
WORKDIR /myapp-dir
COPY ./build/libs/ocp-demo-1-0.0.1-SNAPSHOT.jar ocp-demo-1-0.0.1-SNAPSHOT.jar
EXPOSE 9001
CMD [ "java", "-jar", "ocp-demo-1-0.0.1-SNAPSHOT.jar" ]
