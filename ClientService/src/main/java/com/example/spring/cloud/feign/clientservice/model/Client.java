package com.example.spring.cloud.feign.clientservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "clients")
@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String id_card;
}
