package com.example.spring.cloud.feignclient.orderservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Table(name = "orders")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int client_id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private List<OrderLine> lines = new ArrayList<>();

    private Date order_date;

    public float getTotal(){
        return lines.stream()
                .map(x -> x.getUnit_price() *
                        (1 + x.getTax()) *
                        x.getAmount())
                .collect(Collectors.summingDouble(Float::doubleValue)).floatValue();
    }
}
