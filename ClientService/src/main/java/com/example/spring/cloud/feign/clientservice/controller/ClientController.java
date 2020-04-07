package com.example.spring.cloud.feign.clientservice.controller;

import com.example.spring.cloud.feign.clientservice.dto.ClientDTO;
import com.example.spring.cloud.feign.clientservice.service.ClientService;
import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping(value = "/client")
    public ClientDTO saveClient(@RequestBody ClientDTO clientDto) {
        if (clientDto.getId() == null) return clientService.saveClientWithOrder(clientDto);
        else return clientService.saveOrderForClient(clientDto);
    }
}
