package com.example.spring.cloud.feignclient.orderservice.service;

import com.example.spring.cloud.feignclient.orderservice.dto.OrderDTO;
import com.example.spring.cloud.feignclient.orderservice.mapper.OrderMapper;
import com.example.spring.cloud.feignclient.orderservice.model.Order;
import com.example.spring.cloud.feignclient.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getOrdersByClient(int clientId){
        List<Order> list = new ArrayList<>();
        orderRepository.findOrdersByClientId(clientId).forEach(c -> list.add(c));
        return list;
    }

    public OrderDTO saveOrder(OrderDTO orderDto){
        Order order = OrderMapper.INSTANCE.toOrder(orderDto);
        return OrderMapper.INSTANCE.toOrderDTO(orderRepository.save(order));
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
