package com.example.spring.cloud.feignclient.orderservice.repository;

import com.example.spring.cloud.feignclient.orderservice.model.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface OrderRepository extends CrudRepository<Order, Integer> {
    @Query("SELECT o FROM Order o WHERE o.client_id = :clientId")
    List<Order> findOrdersByClientId(@Param("clientId") int clientId);
}
