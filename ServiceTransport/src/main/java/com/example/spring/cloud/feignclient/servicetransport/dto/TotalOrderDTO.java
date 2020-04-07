package com.example.spring.cloud.feignclient.servicetransport.dto;

import lombok.Data;

@Data
public class TotalOrderDTO {
    private Long order_id;
    private float total;
    private float total_tax;
}