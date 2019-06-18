package poc.resource_server

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class ResourceServerApplication

fun main(args: Array<String>) {
    SpringApplication.run(ResourceServerApplication::class.java, *args)
}
