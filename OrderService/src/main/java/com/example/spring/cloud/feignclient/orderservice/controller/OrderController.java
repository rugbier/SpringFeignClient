package com.example.spring.cloud.feignclient.orderservice.controller;

import com.example.spring.cloud.feignclient.orderservice.model.Item;
import com.example.spring.cloud.feignclient.orderservice.model.Order;
import com.example.spring.cloud.feignclient.orderservice.model.OrderLine;
import com.example.spring.cloud.feignclient.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
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

    @PostMapping(value = "/order")
    public Order saveOrder(@RequestBody Order order){
        Order savedOrder = orderRepository.save(order);
        return savedOrder;
    }


}
