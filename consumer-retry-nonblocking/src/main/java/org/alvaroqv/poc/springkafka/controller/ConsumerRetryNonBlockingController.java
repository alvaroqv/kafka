package org.alvaroqv.poc.springkafka.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerRetryNonBlockingController {

    @GetMapping(value="/hello")
    public String getMethodName() {
        return "Teste de Hello World";
    }
}
