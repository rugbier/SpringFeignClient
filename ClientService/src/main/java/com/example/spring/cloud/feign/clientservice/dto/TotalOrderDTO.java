package com.example.spring.cloud.feign.clientservice.dto;

import lombok.Data;

@Data
public class TotalOrderDTO {
    private Long order_id;
    private float total;
    private float total_tax;
}