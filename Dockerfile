
FROM amazoncorretto:19-alpine-jdk

MAINTAINER emaaristimuno

COPY target/dsm-0.0.1-SNAPSHOT.jar dsm-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/dsm-0.0.1-SNAPSHOT.jar"]