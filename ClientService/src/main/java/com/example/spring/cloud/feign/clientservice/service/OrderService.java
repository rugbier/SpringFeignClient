package com.example.spring.cloud.feign.clientservice.service;

import com.example.spring.cloud.feign.clientservice.dto.OrderDTO;
import com.example.spring.cloud.feign.clientservice.externalservice.OrderServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderServiceClient orderService;


    public List<OrderDTO> getOrdersByClient(int clientId) {
        return orderService.getOrdersByClient(clientId);
    }

    public OrderDTO saveOrder(OrderDTO order){
        return orderService.saveOrder(order);
    }
}
