package com.example.spring.cloud.feignclient.clientservice.controller;

import com.example.spring.cloud.feignclient.clientservice.model.Client;
import com.example.spring.cloud.feignclient.clientservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(value = "/client")
    public List<Client> getClient() {
        List<Client> list = new ArrayList<Client>();
        clientRepository.findAll().forEach(c -> list.add(c));
        return list;
    }
}
