package com.example.spring.cloud.feign.clientservice.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ItemDTO {
    private Long id;
    private String name;
    private String description;
    private Date date_added;
}
