package com.example.spring.cloud.feign.clientservice.controller;

import com.example.spring.cloud.feignclient.servicetransport.dto.ClientDTO;
import com.example.spring.cloud.feignclient.servicetransport.dto.OrderDTO;
import com.example.spring.cloud.feignclient.servicetransport.dto.TotalClientOrdersDTO;
import com.example.spring.cloud.feignclient.servicetransport.dto.TotalOrderDTO;
import com.example.spring.cloud.feign.clientservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ClientDTO saveClientAndOrder(@RequestBody ClientDTO clientDto) {
        if (clientDto.getId() == null) return clientService.saveClientWithOrder(clientDto);
        else return clientService.saveOrderForClient(clientDto);
    }

    @GetMapping(value = "/client/{clientId}/order/{orderId}")
    public OrderDTO getOrderFromClient(@PathVariable("clientId") int clientId, @PathVariable("orderId") int orderId){
        return clientService.getOrderFromClient(clientId, orderId);
    }

    @GetMapping(value = "/client/{clientId}/order/{orderId}/total")
    public TotalOrderDTO getTotalOfOrder(@PathVariable("clientId") int clientId, @PathVariable("orderId") int orderId){
        return clientService.getTotalOfOrder(clientId, orderId);
    }

    @GetMapping(value = "/client/{clientId}/order/total")
    public TotalClientOrdersDTO getTotalOfClient(@PathVariable("clientId") int clientId){
        return clientService.getTotalOfClient(clientId);
    }
}
