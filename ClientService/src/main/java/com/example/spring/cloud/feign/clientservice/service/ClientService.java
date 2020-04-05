package com.example.spring.cloud.feign.clientservice.service;

import com.example.spring.cloud.feign.clientservice.dto.ClientDTO;
import com.example.spring.cloud.feign.clientservice.dto.OrderDTO;
import com.example.spring.cloud.feign.clientservice.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OrderService orderService;

    public List<ClientDTO> getAllClients(){
        List<ClientDTO> list = new ArrayList<>();
        clientRepository.findAll().forEach(c -> {
            ClientDTO client = new ClientDTO();
            client.setId(c.getId());
            client.setEmail(c.getEmail());
            client.setId_card(c.getId_card());
            client.setName(c.getName());
            client.setSurname(c.getSurname());
            client.setPhone(c.getPhone());
            List<OrderDTO> orders = orderService.getOrdersByClient((int)c.getId());
            client.setOrders(orders);
            list.add(client);
        });

        return list;
    }
}
