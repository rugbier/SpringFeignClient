package com.example.spring.cloud.feign.clientservice.repository;

import com.example.spring.cloud.feign.clientservice.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ClientRepository extends CrudRepository<Client, Integer> {
}
