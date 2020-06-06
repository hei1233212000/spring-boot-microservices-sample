package poc.resource_server.config

import org.springframework.context.annotation.Bean
import org.springframework.http.HttpMethod
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity
import org.springframework.security.config.web.server.ServerHttpSecurity
import org.springframework.security.web.server.SecurityWebFilterChain

const val AUTHORITY_READ = "protected:read"
const val AUTHORITY_WRITE = "protected:write"

@EnableWebFluxSecurity
class SecurityConfiguration {
    @Bean
    fun springSecurityFilterChain(http: ServerHttpSecurity): SecurityWebFilterChain? {
        return http
            .authorizeExchange { exchanges: ServerHttpSecurity.AuthorizeExchangeSpec ->
                exchanges
                    /* we check the "scope" attribute in JWT to see if it has "protected:read" */
                    .pathMatchers(HttpMethod.GET, "/protected/reader").hasAuthority("SCOPE_$AUTHORITY_READ")
                    .pathMatchers(HttpMethod.GET, "/protected/**").authenticated()
                    .anyExchange().permitAll()
            }
            .oauth2ResourceServer { oauth2ResourceServer: ServerHttpSecurity.OAuth2ResourceServerSpec ->
                oauth2ResourceServer
                    .jwt(Customizer.withDefaults())
            }.build()
    }
}
