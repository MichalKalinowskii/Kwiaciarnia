package com.kwiat.kwiaciarnia;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Kwiaciarnia API")
                        .version("1.0")
                        .description("Documentation for Kwiaciarnia API"))
                .servers(List.of(new Server().url("/")));
    }
}