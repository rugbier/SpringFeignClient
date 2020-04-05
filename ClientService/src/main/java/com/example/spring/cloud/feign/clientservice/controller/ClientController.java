package com.example.spring.cloud.feign.clientservice.controller;

import com.example.spring.cloud.feign.clientservice.dto.ClientDTO;
import com.example.spring.cloud.feign.clientservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {


    @Autowired
    private ClientService clientService;


    @GetMapping(value = "/client")
    public List<ClientDTO> getClient() {
       return clientService.getAllClients();
    }
}
