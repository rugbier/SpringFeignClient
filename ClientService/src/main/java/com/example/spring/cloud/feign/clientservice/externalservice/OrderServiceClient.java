package com.example.spring.cloud.feign.clientservice.externalservice;

import com.example.spring.cloud.feign.clientservice.configuration.OrderServiceClientConfiguration;
import com.example.spring.cloud.feign.clientservice.dto.OrderDTO;
import com.example.spring.cloud.feign.clientservice.hystrix.OrderServiceClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "orderService", url = "http://localhost:8082/",
             configuration = OrderServiceClientConfiguration.class,
             fallback = OrderServiceClientFallBack.class)
public interface OrderServiceClient {
    @RequestMapping(method = RequestMethod.GET, value = "/client/{clientId}/order")
    List<OrderDTO> getOrdersByClient(@PathVariable("clientId") int clientId);
}
