package com.example.spring.cloud.feignclient.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


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
    private int client_id;
//    @OneToMany
//    @JoinColumn(name = "order_id")
//    private List<OrderLine> lines;
    private Date order_date;

}
