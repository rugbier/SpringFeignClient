package com.example.spring.cloud.feign.clientservice.hystrix;

import com.example.spring.cloud.feignclient.servicetransport.dto.OrderDTO;
import com.example.spring.cloud.feignclient.servicetransport.dto.TotalClientOrdersDTO;
import com.example.spring.cloud.feignclient.servicetransport.dto.TotalOrderDTO;
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
    public TotalOrderDTO getTotalOfOrder(int clientId, int orderId) {
        return null;
    }

    @Override
    public TotalClientOrdersDTO getTotalOfClient(int clientId) {
        return null;
    }
}
