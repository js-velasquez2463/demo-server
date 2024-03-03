FROM adoptopenjdk/openjdk11:latest

RUN groupadd -r mipams && useradd --no-log-init -r -g mipams mipams

WORKDIR /app
RUN mkdir /app/assets
RUN chown -R mipams:mipams /app/assets

USER mipams:mipams
VOLUME /tmp
ARG JAR_FILE=target/demo-1.0.jar
ADD ${JAR_FILE} /app/app.jar

EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app/app.jar"]