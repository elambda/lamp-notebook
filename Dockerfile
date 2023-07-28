FROM openjdk:17

RUN mkdir /lamp-ws

WORKDIR /lamp-ws

COPY build/libs/lamp-notebook-0.0.1-SNAPSHOT.jar lamp-notebook-0.0.1-SNAPSHOT.jar

RUN chmod +x ./lamp-notebook-0.0.1-SNAPSHOT.jar

EXPOSE 9090

ENTRYPOINT ["java","-jar","/lamp-ws/lamp-notebook-0.0.1-SNAPSHOT.jar"]