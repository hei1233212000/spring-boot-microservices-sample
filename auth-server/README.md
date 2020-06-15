### Auth Service

We use Keycloak as our Auth server

#### Build
>$ docker build .

#### Run
>$ docker-compose up -d

#### Generate Token for authenticated user
>$ curl -X POST -d "client_id=spring-boot-poc-client" -d "username=spring-boot-poc-user" -d "password=abc123" -d "grant_type=password" -v "http://localhost:8100/auth/realms/spring-boot-poc-realm/protocol/openid-connect/token"

#### Generate Token for reader
>$ curl -X POST -d "client_id=spring-boot-poc-client-reader" -d "username=spring-boot-poc-user" -d "password=abc123" -d "grant_type=password" -v "http://localhost:8100/auth/realms/spring-boot-poc-realm/protocol/openid-connect/token"
