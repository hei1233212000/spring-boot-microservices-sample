package poc.resource_server.web.reactive.router

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken
import org.springframework.web.reactive.function.BodyInserters.fromValue
import org.springframework.web.reactive.function.server.HandlerFunction
import org.springframework.web.reactive.function.server.RequestPredicates.GET
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok

@Configuration
class ProtectedResourcesRouter {
    @Bean
    fun routeTpProtectedResources(): RouterFunction<ServerResponse> {
        return RouterFunctions
            .route(
                GET("/protected/reader"),
                HandlerFunction {
                    ok()
                        .contentType(MediaType.TEXT_PLAIN)
                        .body(fromValue("You have READ access"))
                }
            )
            .andRoute(
                GET("/protected"),
                HandlerFunction { serverRequest ->
                    serverRequest.principal()
                        .map { it as JwtAuthenticationToken }
                        .flatMap { jwtAuthenticationToken ->
                            ok()
                                .contentType(MediaType.TEXT_PLAIN)
                                .body(fromValue("You are \"${jwtAuthenticationToken.name}\""))
                        }
                }
            )
    }
}