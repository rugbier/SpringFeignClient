package com.example.spring.cloud.feignclient.orderservice.controller;

import com.example.spring.cloud.feignclient.orderservice.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
    @Autowired
    private APPStatus status;

    @PostMapping(value = "/status")
    public String changeStatus(@RequestBody String newStatus){
        status.appStatus = newStatus;
        return status.appStatus;
    }

    @GetMapping(value = "/status")
    public String getAppStatus(){
        return status.appStatus;
    }


    @Component
    public static class APPStatus{
        public final String NO_ERROR = "NO_ERROR";
        public final String ERROR = "ERROR";
        public final String EXCEPTION = "EXCEPTION";

        public String appStatus = NO_ERROR;
    }
}
