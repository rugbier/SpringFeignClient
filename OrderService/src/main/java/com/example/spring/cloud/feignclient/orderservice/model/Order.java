package com.example.spring.cloud.feignclient.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Table(name = "orders")
@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    private long id;
    @OneToMany
    @JoinColumn(name = "order_id")
    private List<OrderLine> lines;
    private Date order_date;

}
