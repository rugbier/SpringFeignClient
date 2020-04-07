package com.example.spring.cloud.feignclient.servicetransport.dto;

import lombok.Data;

import java.util.List;

@Data
public class ClientDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String id_card;

    List<OrderDTO> orders;
}
