package com.example.spring.cloud.feign.clientservice.mapper;

import com.example.spring.cloud.feign.clientservice.dto.ClientDTO;
import com.example.spring.cloud.feign.clientservice.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

//    @Mapping(target = "orders", ignore = true)
    ClientDTO toClientDTO(Client client);

//    @Mapping(target = "orders", ignore = true)
    Client toClient(ClientDTO client);
}

