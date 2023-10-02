FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/audiotomeserver-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} audiotomeserver.jar
ENTRYPOINT ["java","-jar","/audiotomeserver.jar"]