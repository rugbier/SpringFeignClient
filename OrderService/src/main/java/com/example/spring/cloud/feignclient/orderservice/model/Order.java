package com.example.spring.cloud.feignclient.orderservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Table(name = "orders")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue
    @JsonIgnore
    private long id;

    @JsonIgnore
    private int client_id;

    @OneToMany
    @JoinColumn(name = "order_id")
    private List<OrderLine> lines;

    private Date order_date;

}
