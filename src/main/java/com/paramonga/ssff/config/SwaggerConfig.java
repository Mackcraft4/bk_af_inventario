package com.paramonga.ssff.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableOpenApi
//@EnableWebMvc
public class SwaggerConfig {

    @Bean
    public Docket api() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("Control de EPPs")
                .version("1.0")
                .license(null)
                .licenseUrl(null)
                .termsOfServiceUrl(null)
                .description("Servicios para el sistema -Control de EPPs-")
                .build();

        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo)
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.paramonga.ssff.controllers"))
                .paths(PathSelectors.regex("/.*"))
                .build();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}

