package com.example.spring.cloud.feignclient.orderservice.service;

import com.example.spring.cloud.feignclient.orderservice.model.Order;
import com.example.spring.cloud.feignclient.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrdersByClient(int clientId){
        List<Order> list = new ArrayList<>();
        orderRepository.findOrdersByClientId(clientId).forEach(c -> list.add(c));
        return list;
    }

    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }

    public Order getOrderByIdAndClient(int clientId, int orderId) {
        return orderRepository.findByIdAndClient(clientId, orderId);
    }

    public float getTotalOfOrder(int clientId, int orderId) {
        return orderRepository.findByIdAndClient(clientId, orderId).getTotal();
    }

    public float getTotalOfClient(int clientId) {
        return (float) orderRepository.findOrdersByClientId(clientId).stream().mapToDouble(c -> c.getTotal()).sum();
    }
}