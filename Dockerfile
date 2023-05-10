
FROM amazoncorretto:19-alpine-jdk

MAINTAINER emaaristimuno

COPY target/dsm-0.0.1-SNAPSHOT dsm-0.0.1-SNAPSHOT

ENTRYPOINT ["java","-jar","/dsm-0.0.1-SNAPSHOT"]