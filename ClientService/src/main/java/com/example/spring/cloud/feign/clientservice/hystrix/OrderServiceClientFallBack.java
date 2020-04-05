package com.example.spring.cloud.feign.clientservice.hystrix;

import com.example.spring.cloud.feign.clientservice.dto.OrderDTO;
import com.example.spring.cloud.feign.clientservice.externalservice.OrderServiceClient;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class OrderServiceClientFallBack implements OrderServiceClient {

    @Override
    public List<OrderDTO> getOrdersByClient(int clientId) {
        return Collections.emptyList();
    }
}
