package com.example.spring.cloud.feignclient.orderservice.dto;

import lombok.Data;

@Data
public class OrderLineDTO {
    private Long id;
    private ItemDTO item;
    private int amount;
    private float unit_price;
    private float tax;
}
