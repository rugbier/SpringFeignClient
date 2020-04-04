package com.example.spring.cloud.feignclient.orderservice.controller;

import com.example.spring.cloud.feignclient.orderservice.model.Order;
import com.example.spring.cloud.feignclient.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping(value = "/order/{clientId}")
    public List<Order> getOrdersByClient(@PathVariable("clientId") int clientId) {
        List<Order> list = new ArrayList<>();
        orderRepository.findOrdersByClientId(clientId).forEach(c -> list.add(c));
        return list;
    }


}
