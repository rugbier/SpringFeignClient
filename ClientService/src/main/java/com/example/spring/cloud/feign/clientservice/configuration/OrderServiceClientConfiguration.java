package com.example.spring.cloud.feign.clientservice.configuration;

import feign.Logger;
import feign.RequestInterceptor;
import feign.codec.ErrorDecoder;
import org.apache.http.entity.ContentType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderServiceClientConfiguration {
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new CustomErrorDecoder();
    }

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header("user", "ajeje");
            requestTemplate.header("password", "brazof");
            requestTemplate.header("Accept", ContentType.APPLICATION_JSON.getMimeType());
        };
    }
}
