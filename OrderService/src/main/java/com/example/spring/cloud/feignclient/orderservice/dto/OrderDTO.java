package com.example.spring.cloud.feignclient.orderservice.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {
    private Long id;
    private int client_id;
    private List<OrderLineDTO> lines;
    private Date order_date;
}