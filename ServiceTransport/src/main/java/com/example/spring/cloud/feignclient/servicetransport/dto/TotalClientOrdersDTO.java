package com.example.spring.cloud.feignclient.servicetransport.dto;

import lombok.Data;

@Data
public class TotalClientOrdersDTO {
    private Long client_id;
    private int total_orders;
    private float total;
    private float total_tax;
}