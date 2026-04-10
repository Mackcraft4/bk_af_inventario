package com.paramonga.ssff.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final EnvInterceptor envInterceptor;

    public WebConfig(EnvInterceptor envInterceptor) {
        this.envInterceptor = envInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(envInterceptor)
                .addPathPatterns("/api/**");
    }
}