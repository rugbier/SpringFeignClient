package com.example.spring.cloud.feignclient.orderservice.dto;

import lombok.Data;

@Data
public class TotalOrderDTO {
    private Long order_id;
    private float total;
    private float total_tax;
}
