package com.etek.ems.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI(@Value("${application-description}") 
                                 String appDesciption, 
                                 @Value("${application-version}") 
                                 String appVersion) {
        return new OpenAPI()
                .info(new Info()
                .title("Employee Managment System")
                .version(appVersion)
                .description(appDesciption)
                );
    }

}