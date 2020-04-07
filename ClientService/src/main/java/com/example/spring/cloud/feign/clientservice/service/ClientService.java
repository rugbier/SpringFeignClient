package com.example.spring.cloud.feign.clientservice.service;

import com.example.spring.cloud.feign.clientservice.dto.ClientDTO;
import com.example.spring.cloud.feign.clientservice.dto.OrderDTO;
import com.example.spring.cloud.feign.clientservice.mapper.ClientMapper;
import com.example.spring.cloud.feign.clientservice.model.Client;
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
            ClientDTO client = ClientMapper.INSTANCE.toClientDTO(c);
            List<OrderDTO> orders = orderService.getOrdersByClient(c.getId().intValue());
            client.setOrders(orders);
            list.add(client);
        });

        return list;
    }

    public ClientDTO saveClientWithOrder(ClientDTO clientDto) {
        Client client = ClientMapper.INSTANCE.toClient(clientDto);
        Client savedClient = clientRepository.save(client);
        clientDto.getOrders().stream().forEach(o -> {
            o.setClient_id(client.getId());
            OrderDTO savedOrder = orderService.saveOrder(o);
            savedClient.getOrders().add(savedOrder);
        });
        return ClientMapper.INSTANCE.toClientDTO(savedClient);
    }

    public ClientDTO saveOrderForClient(ClientDTO client) {
        client.getOrders().stream().forEach(o -> {
            o.setClient_id(client.getId());
            OrderDTO savedOrder = orderService.saveOrder(o);
        });
        return client;
    }

}
