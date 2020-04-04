package com.example.spring.cloud.feign.clientservice.controller;

import com.example.spring.cloud.feign.clientservice.model.Client;
import com.example.spring.cloud.feign.clientservice.repository.ClientRepository;
import com.example.spring.cloud.feign.clientservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OrderService orderService;


    @GetMapping(value = "/client")
    public List<Client> getClient() {

        orderService.getOrders();

        List<Client> list = new ArrayList<Client>();
        clientRepository.findAll().forEach(c -> list.add(c));
        return list;
    }
}