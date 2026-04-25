FROM eclipse-temurin:21-jdk
LABEL maintainer="kamal"
WORKDIR /myapp-dir
COPY ./build/libs/openshift-demo-0.0.1-SNAPSHOT.jar openshift-demo-0.0.1-SNAPSHOT.jar
EXPOSE 9001
CMD [ "java", "-jar", "openshift-demo-0.0.1-SNAPSHOT.jar" ]
