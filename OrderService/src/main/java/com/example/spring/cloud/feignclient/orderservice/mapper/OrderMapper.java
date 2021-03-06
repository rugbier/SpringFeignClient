package com.example.spring.cloud.feignclient.orderservice.mapper;

import com.example.spring.cloud.feignclient.servicetransport.dto.OrderDTO;
import com.example.spring.cloud.feignclient.orderservice.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    OrderDTO toOrderDTO(Order order);
    Order toOrder(OrderDTO order);

    List<OrderDTO> toOrderDTOList(List<Order> lines);

}
