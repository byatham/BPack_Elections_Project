FROM openjdk:17-alpine
EXPOSE 2004
COPY target/elections-project-app.jar  /usr/app/
WORKDIR  /usr/app
ENTRYPOINT ["java","-jar","elections-project-app.jar"]