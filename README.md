#### Project description
Sample project to show how to build microservices by using Kotlin, Spring Boo and Gradle

#### Components

- API Gateway
- Discovery Server
- Resource Server
- Auth Server

#### How to start

##### Start Discovery Server
>$ SPRING_PROFILES_ACTIVE=peer1 ./gradlew :discovery-server:clean :discovery-server:bootRun

>$ SPRING_PROFILES_ACTIVE=peer2 ./gradlew :discovery-server:clean :discovery-server:bootRun

##### Start Resource Server
>$ SPRING_PROFILES_ACTIVE=peer1 ./gradlew :resource-server:clean :resource-server:bootRun

>$ SPRING_PROFILES_ACTIVE=peer2 ./gradlew :resource-server:clean :resource-server:bootRun

##### Start API Gateway
>$ ./gradlew :api-gateway:clean :api-gateway:bootRun

#### Start Auth Server
Please check the [Auth Server README](./auth-server/README.md)

#### Verify
- Go to http://localhost:9999/discovery-server/ to access the Eureka page via the API Gateway
- Call http://localhost:9999/api/server-info to access the endpoint for the Resource Server via the API Gateway
