FROM eclipse-temurin:17-jre

WORKDIR /app

COPY target/corerouter-email-worker-1.0.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["sh", "-c", "java -cp app.jar $WORKER_CLASS"]