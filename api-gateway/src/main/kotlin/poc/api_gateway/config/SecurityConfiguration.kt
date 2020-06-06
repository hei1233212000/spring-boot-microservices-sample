package poc.api_gateway.config

import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain

/**
 * Provide authentication check for specific path
 */
@EnableWebFluxSecurity
class SecurityConfiguration {
    @Bean
    fun springSecurityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain? {
        return http
            .authorizeExchange { exchanges: ServerHttpSecurity.AuthorizeExchangeSpec ->
                exchanges
                    .pathMatchers(HttpMethod.GET, "/**/protected/**").authenticated()
                    .anyExchange().permitAll()
            }
            .oauth2ResourceServer { oauth2ResourceServer: ServerHttpSecurity.OAuth2ResourceServerSpec ->
                oauth2ResourceServer
                    .jwt(Customizer.withDefaults())
            }.build()
    }
}
