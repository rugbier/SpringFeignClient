package com.example.spring.cloud.feign.clientservice.externalservice;

import com.example.spring.cloud.feign.clientservice.configuration.OrderServiceClientConfiguration;
import com.example.spring.cloud.feign.clientservice.dto.OrderDTO;
import com.example.spring.cloud.feign.clientservice.hystrix.OrderServiceClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "orderService", url = "http://localhost:8082/",
             configuration = OrderServiceClientConfiguration.class,
             fallback = OrderServiceClientFallBack.class)
public interface OrderServiceClient {
    @RequestMapping(method = RequestMethod.GET, value = "/order")
    List<OrderDTO> getOrdersByClient(@RequestParam("clientId") int clientId);


    @RequestMapping(method = RequestMethod.POST, value = "/order")
    OrderDTO saveOrder(@RequestBody OrderDTO order);

    @RequestMapping(method = RequestMethod.GET, value = "order/{orderId}")
    OrderDTO getOrderByIdAndClient(@RequestParam("clientId") int clientId, @PathVariable("orderId") int orderId);

    @RequestMapping(method = RequestMethod.GET, value = "/order/{orderId}/total")
    float getTotalOfOrder(@RequestParam("clientId") int clientId, @PathVariable("orderId") int orderId);

    @RequestMapping(method = RequestMethod.GET, value = "/order/total")
    float getTotalOfClient(@RequestParam("clientId") int clientId);
}
