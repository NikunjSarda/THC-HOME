

FROM openjdk:latest
VOLUME /tmp
EXPOSE 8300
COPY build/libs/THC-0.0.1-SNAPSHOT.jar THC-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","THC-0.0.1-SNAPSHOT.jar"]

FROM library/postgres
COPY init.sql /docker-entyrpoint-initdb.d/