package poc.resource_server.web.reactive.router

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.*

@Configuration
class ServerInfoRouter {
    @Bean
    fun route(): RouterFunction<ServerResponse> {
        return RouterFunctions
            .route(
                RequestPredicates.GET("/server-info"),
                HandlerFunction<ServerResponse> {serverRequest ->
                    val serverInfo = ServerInfo(
                        port = serverRequest.uri().port
                    )

                    ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromObject(serverInfo))
                }
            )
    }

    data class ServerInfo(
        val port: Int
    )
}