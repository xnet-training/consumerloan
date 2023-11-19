ARG PORT=8080
FROM maven:3.6.3-openjdk-15 as BUILD

LABEL version=0.1.0

COPY . /usr/src/app

RUN mvn --batch-mode -f /usr/src/app/pom.xml -s /usr/src/app/ci_settings.xml clean package && \
    test $(find ./ -type f -name '*-api.jar' | wc -l) -eq 1

FROM amazoncorretto:15-alpine-jdk
#FROM openjdk:15-jdk
ENV PORT ${PORT}
ENV SPRING_PROFILES_ACTIVE=kubernetes
ENV SPRING_APPLICATION_NAME=customerloan
ENV SPRING_CLOUD_VAULT_SECRET=changeme
ENV SPRING_CLOUD_VAULT_URI=http://vault-service.management.svc.domain.local:8200
ENV SPRING_CONFIG_LOCATION=file:///opt/config/

WORKDIR /usr/app
COPY --from=BUILD /usr/src/app/api/target/microservicio-api.jar /usr/app/

EXPOSE ${PORT}

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar","/usr/app/microservicio-api.jar"]
