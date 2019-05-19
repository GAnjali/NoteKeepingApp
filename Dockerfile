FROM java:8
VOLUME /tmp
ARG JAR_FILE=target/note-keeping-app.jar
ADD ${JAR_FILE} note-keeping-app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/note-keeping-app.jar"]
EXPOSE 5051