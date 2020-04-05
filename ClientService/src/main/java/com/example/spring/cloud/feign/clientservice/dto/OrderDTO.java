package com.example.spring.cloud.feign.clientservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrderDTO {
    private long id;
    private Date order_date;
}
