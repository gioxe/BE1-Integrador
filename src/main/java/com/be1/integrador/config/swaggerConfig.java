package com.be1.integrador.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class swaggerConfig {
    @Bean
    public OpenAPI customApi() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Documentación de la API - APP de gestión de turnos odontológicos.")
                        .description("Este documento contiene toda la documentación de la API de la aplicación.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Autor: Giovanny Cárdenas")
                                .email("ing.gcardenas@gmail.com")
                                .url("https://github.com/gioxe")
                                .url("https://www.linkedin.com/in/giovanny-cardenas")
                        )
                );
    }
}