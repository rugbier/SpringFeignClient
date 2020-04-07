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

    @Override
    public OrderDTO saveOrder(OrderDTO order) {
        return null;
    }

    @Override
    public OrderDTO getOrderByIdAndClient(int clientId, int orderId) {
        return null;
    }

    @Override
    public float getTotalOfOrder(int clientId, int orderId) {
        return 0;
    }

    @Override
    public float getTotalOfClient(int clientId) {
        return 0;
    }
}
