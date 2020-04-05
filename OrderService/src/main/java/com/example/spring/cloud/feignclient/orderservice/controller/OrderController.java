package com.example.spring.cloud.feignclient.orderservice.controller;

import com.example.spring.cloud.feignclient.orderservice.model.Item;
import com.example.spring.cloud.feignclient.orderservice.model.Order;
import com.example.spring.cloud.feignclient.orderservice.model.OrderLine;
import com.example.spring.cloud.feignclient.orderservice.repository.OrderRepository;
import com.example.spring.cloud.feignclient.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/order")
    public Order saveOrder(@RequestBody Order order){
        return orderService.saveOrder(order);
    }

    @GetMapping(value = "/client/{clientId}/order")
    public List<Order> getOrdersByClient(@PathVariable("clientId") int clientId) {
        return orderService.getOrdersByClient(clientId);
    }

    @GetMapping(value = "/client/{clientId}/order/{orderId}")
    public Order getOrderByIdAndClient(@PathVariable("clientId") int clientId, @PathVariable("orderId") int orderId) {
        return orderService.getOrderByIdAndClient(clientId, orderId);
    }

    @GetMapping(value = "/client/{clientId}/order/{orderId}/total")
    public float getTotalOfOrder(@PathVariable("clientId") int clientId, @PathVariable("orderId") int orderId) {
        return orderService.getTotalOfOrder(clientId, orderId);
    }

    @GetMapping(value = "/client/{clientId}/total")
    public float getTotalOfClient(@PathVariable("clientId") int clientId) {
        return orderService.getTotalOfClient(clientId);
    }


}
