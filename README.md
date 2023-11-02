# Microservicio SD Customer Loan

## Configurar Vault

Ingresar a la carpeta `dev-environment/terraform` y ejecutar los comandos siguientes:

> Nota 1: ajustar en archivo main.tf la URL y Token de acceso a Vault.

```sh
terraform init
terraform apply --auto-aprove
```

```sh
$ mvn clean install
$ mvn spring-boot:run -pl customerloan
```

Acceder a Documentacion Swagger

```sh
http://localhost:8082/swagger-ui/index.html
```

```cmd
java -jar .\api\target\microservicio-api.jar --spring.profiles.active=dev
```
## Ejecucion con Elastic APM

```sh
java -javaagent:../elastic-apm-agent-1.43.0.jar \
  -Delastic.apm.service_name=consumerloan \
  -Delastic.apm.secret_token= \
  -Delastic.apm.server_url=http://172.17.8.220:8200 \
  -Delastic.apm.environment=dev \
  -Delastic.apm.application_packages=com.crossnetcorp.banking \
  -jar microservice.jar
```

## En DOS

```dos
java -javaagent:../elastic-apm-agent-1.43.0.jar -jar .\api\target\microservicio-api.jar --spring.profiles.active=dev --spring.config.location=file:api\src\main\resources\application-dev.yaml
```


```dos
java -javaagent:../elastic-apm-agent-1.43.0.jar -Delastic.apm.service_name=consumerloan -Delastic.apm.secret_token= -Delastic.apm.server_url=http://172.17.8.220:8200 -Delastic.apm.environment=dev -Delastic.apm.application_packages=com.crossnetcorp.banking -jar .\api\target\microservicio-api.jar --spring.profiles.active=dev

```