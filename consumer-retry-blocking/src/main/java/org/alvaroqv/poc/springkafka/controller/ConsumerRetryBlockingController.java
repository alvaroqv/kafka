package org.alvaroqv.poc.springkafka.controller;

import org.alvaroqv.poc.springkafka.service.ConsumerRetryBlockingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerRetryBlockingController {

    @Autowired
    ConsumerRetryBlockingService service;

    @GetMapping(value="/hello")
    public String getHello() {
        return "Teste de Hello World";
    }

    @GetMapping(value="/messages")
    public String getMessages() {
        return service.showMessages();
    }

    @GetMapping(value="/messages/clear")
    public String getMessagesCleanCache() {
        service.cleanCache();
        return "Cache clear";
    }
}
