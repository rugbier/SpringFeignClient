package com.example.spring.cloud.feign.clientservice.externalservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "orderService",
        url = "http://localhost:8082/")
public interface OrderServiceClient {
    @RequestMapping(method = RequestMethod.GET, value = "/order")
    List<OrderDTO> getOrders();
}
