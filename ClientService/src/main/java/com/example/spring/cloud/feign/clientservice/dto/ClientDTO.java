package com.example.spring.cloud.feign.clientservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClientDTO {
    private long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String id_card;

    List<OrderDTO> orders;
}
