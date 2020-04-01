package com.example.spring.cloud.feignclient.orderservice.repository;

import com.example.spring.cloud.feignclient.orderservice.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {
}
