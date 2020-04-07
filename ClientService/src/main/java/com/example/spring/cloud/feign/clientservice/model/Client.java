package com.example.spring.cloud.feign.clientservice.model;

import com.example.spring.cloud.feignclient.servicetransport.dto.OrderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "clients")
@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String id_card;

    @Transient
    List<OrderDTO> orders = new ArrayList<>();
}
