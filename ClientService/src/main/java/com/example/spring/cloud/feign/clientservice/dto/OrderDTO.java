package com.example.spring.cloud.feign.clientservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrderDTO {
    private Long client_id;
    private Date order_date;
    private List<OrderLineDTO> lines;
}
