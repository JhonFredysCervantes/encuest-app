package com.unimag.encuestapp.application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;

/**
 * Web configuration
 */
@Configuration
@EnableWebFlux
public class WebConf implements WebFluxConfigurer {

    /**
     * Add CORS mappings
     *
     * @param corsRegistry The CORS registry
     */
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD")
                .maxAge(3600);
    }
}
