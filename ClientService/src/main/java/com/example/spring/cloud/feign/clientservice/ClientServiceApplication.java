package com.example.spring.cloud.feign.clientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
@ComponentScan({"com.example.spring.cloud.feign.clientservice"})
@EntityScan("com.example.spring.cloud.feign.clientservice")
@EnableJpaRepositories("com.example.spring.cloud.feign.clientservice")
public class ClientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }

}
