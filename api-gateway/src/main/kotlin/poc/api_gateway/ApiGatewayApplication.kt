package poc.api_gateway

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties
import org.springframework.context.annotation.Bean


@SpringBootApplication
@EnableDiscoveryClient
class ApiGatewayApplication {
    @Bean
    fun discoveryClientRouteLocator(
        discoveryClient: DiscoveryClient,
        discoveryLocatorProperties: DiscoveryLocatorProperties
    ): DiscoveryClientRouteDefinitionLocator {
        return DiscoveryClientRouteDefinitionLocator(discoveryClient, discoveryLocatorProperties)
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(ApiGatewayApplication::class.java, *args)
}
