package com.example.spring.cloud.feign.clientservice.configuration;

import com.example.spring.cloud.feign.clientservice.exceptions.BadRequestException;
import com.example.spring.cloud.feign.clientservice.exceptions.NotFoundException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        switch (response.status()){
            case 400:
                return new BadRequestException();
            case 404:
                return new NotFoundException();
            default:
                return new Exception("Generic error");
        }
    }
}
