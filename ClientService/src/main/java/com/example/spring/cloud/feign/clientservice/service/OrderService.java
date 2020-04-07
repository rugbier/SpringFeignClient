package com.example.spring.cloud.feign.clientservice.service;

import com.example.spring.cloud.feignclient.servicetransport.dto.OrderDTO;
import com.example.spring.cloud.feignclient.servicetransport.dto.TotalClientOrdersDTO;
import com.example.spring.cloud.feignclient.servicetransport.dto.TotalOrderDTO;
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

    public OrderDTO getOrderFromClient(int clientId, int orderId){
        return orderService.getOrderByIdAndClient(clientId, orderId);
    }

    public TotalOrderDTO getTotalOfOrder(int clientId, int orderId){
        return orderService.getTotalOfOrder(clientId, orderId);
    }

    public TotalClientOrdersDTO getTotalOfClient(int clientId){
        return orderService.getTotalOfClient(clientId);
    }
}
