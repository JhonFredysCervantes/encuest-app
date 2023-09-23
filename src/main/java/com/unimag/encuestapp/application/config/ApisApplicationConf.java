package com.unimag.encuestapp.application.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Apis Application configuration document
 */
@Configuration
public class ApisApplicationConf {

    /**
     * OpenAPI configuration
     *
     * @return OpenAPI instance
     */
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("EncuestApp API")
                        .description("EncuestApp API reference for developers")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("https://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("EncuestApp Wiki Documentation")
                        .url("https://github.com/docs"));
    }
}
