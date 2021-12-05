package com.borman.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.function.Predicate;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
public class SwaggerConfigurations {

    @Bean
    public Docket swagger() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Drive-api")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.borman.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private Predicate<String> paths() {
        return regex("/api/.*");
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Drive API specification",
                "Drive REST APIs",
                "1.0.1",
                "",
                null,
                "License of API",
                "https://www.apache.org/licenses/LICENSE-2.0.html",
                Collections.emptyList());
    }
}