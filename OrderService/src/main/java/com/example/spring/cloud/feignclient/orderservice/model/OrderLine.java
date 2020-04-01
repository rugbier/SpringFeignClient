package com.example.spring.cloud.feignclient.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Table(name = "order_lines")
@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderLine {
    @Id
    @GeneratedValue
    private long id;
    @OneToOne
    @JoinColumn(name = "item_id")
    private Item item;
    private int amount;
    private float unit_price;
    private float tax;
}
