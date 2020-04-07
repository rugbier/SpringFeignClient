package com.example.spring.cloud.feignclient.orderservice.service;

import com.example.spring.cloud.feignclient.orderservice.dto.OrderDTO;
import com.example.spring.cloud.feignclient.orderservice.dto.TotalClientOrdersDTO;
import com.example.spring.cloud.feignclient.orderservice.dto.TotalOrderDTO;
import com.example.spring.cloud.feignclient.orderservice.mapper.OrderMapper;
import com.example.spring.cloud.feignclient.orderservice.model.Order;
import com.example.spring.cloud.feignclient.orderservice.model.OrderLine;
import com.example.spring.cloud.feignclient.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public OrderDTO saveOrder(OrderDTO orderDto){
        Order order = OrderMapper.INSTANCE.toOrder(orderDto);
        return OrderMapper.INSTANCE.toOrderDTO(orderRepository.save(order));
    }

    public Order getOrderByIdAndClient(int clientId, int orderId) {
        return orderRepository.findByIdAndClient(clientId, orderId);
    }

    public TotalOrderDTO getTotalOfOrder(int clientId, int orderId) {
        Order order = orderRepository.findByIdAndClient(clientId, orderId);
        TotalOrderDTO totalOrder = new TotalOrderDTO();
        totalOrder.setOrder_id(order.getId());
        totalOrder.setTotal(((Double) order.getLines().stream().map(x -> x.getUnit_price() * x.getAmount())
                .mapToDouble(Float::doubleValue).sum()).floatValue());
        totalOrder.setTotal_tax(((Double) order.getLines().stream().map(x -> x.getUnit_price() * x.getAmount() * x.getTax())
                .mapToDouble(Float::doubleValue).sum()).floatValue());
        return totalOrder;
    }

    public TotalClientOrdersDTO getTotalOfClient(int clientId) {
        TotalClientOrdersDTO total = new TotalClientOrdersDTO();
        List<Order> orders = orderRepository.findOrdersByClientId(clientId);
        total.setClient_id(Integer.toUnsignedLong(clientId));
        total.setTotal_orders(orders.size());
        total.setTotal((float)orders.stream().flatMap(o -> o.getLines().stream()).map(f -> f.getUnit_price() * f.getAmount()).mapToDouble(Float::doubleValue).sum());
        total.setTotal_tax((float)orders.stream().flatMap(o -> o.getLines().stream()).map(f -> f.getUnit_price() * f.getTax() * f.getAmount()).mapToDouble(Float::doubleValue).sum());

        return total;
    }
}
