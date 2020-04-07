package com.example.spring.cloud.feignclient.servicetransport.dto;

import lombok.Data;

@Data
public class OrderLineDTO {
    private ItemDTO item;
    private int amount;
    private float unit_price;
    private float tax;
}
