package com.example.spring.cloud.feignclient.orderservice.controller;

import com.example.spring.cloud.feignclient.orderservice.dto.OrderDTO;
import com.example.spring.cloud.feignclient.orderservice.mapper.OrderMapper;
import com.example.spring.cloud.feignclient.orderservice.model.Order;
import com.example.spring.cloud.feignclient.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private StatusController.APPStatus status;

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/order")
    public Order saveOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @GetMapping(value = "/client/{clientId}/order")
    public List<OrderDTO> getOrdersByClient(@PathVariable("clientId") int clientId) throws Exception {
        if (status.appStatus.equals(status.ERROR))
            throw new Exception("There was an exception");

        return  OrderMapper.INSTANCE.toOrderDTOList(orderService.getOrdersByClient(clientId));
    }

    @GetMapping(value = "/client/{clientId}/order/{orderId}")
    public OrderDTO getOrderByIdAndClient(@PathVariable("clientId") int clientId, @PathVariable("orderId") int orderId) {
        return  OrderMapper.INSTANCE.toOrderDTO(orderService.getOrderByIdAndClient(clientId, orderId));
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
