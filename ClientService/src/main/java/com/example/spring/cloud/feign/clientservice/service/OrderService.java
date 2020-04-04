package com.example.spring.cloud.feign.clientservice.service;

import com.example.spring.cloud.feign.clientservice.externalservice.OrderDTO;
import com.example.spring.cloud.feign.clientservice.externalservice.OrderServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderServiceClient orderService;


    public List<OrderDTO> getOrders() {
        return orderService.getOrders();
    }
}
