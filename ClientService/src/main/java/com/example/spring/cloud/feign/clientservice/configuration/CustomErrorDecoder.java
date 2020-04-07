package com.example.spring.cloud.feign.clientservice.configuration;

import com.example.spring.cloud.feign.clientservice.exceptions.BadRequestException;
import com.example.spring.cloud.feign.clientservice.exceptions.CustomInternalException;
import com.example.spring.cloud.feign.clientservice.exceptions.NotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.stereotype.Component;

@Component
public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        switch (response.status()){
            case 400:
                return new BadRequestException("Do it properly!!!");
            case 404:
                return new NotFoundException("What are you looking for?");
            case 500:
                return new CustomInternalException("Everything exploded!!");
            default:
                return new Exception("I don't know what happened!");
        }
    }
}
