package org.alvaroqv.poc.springkafka.controller;

import org.alvaroqv.poc.springkafka.service.ProducerDefaultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class ProducerDefaultController {

    @Autowired
    private ProducerDefaultService senderService;

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello you!";
    }

    @GetMapping(value="/send/defaults")
    public String produceDefaultMessage(@RequestParam(value = "key",defaultValue = "default_key") String key, @RequestParam(value = "message", defaultValue = "default message") String message) {
       String msgkey = key.equals("default_key")? UUID.randomUUID().toString():key;
        senderService.send(msgkey, message);
        return String.format("Msg sent Key:%s -  Content:%s ", msgkey, message);
    }

    @GetMapping(value="/send/nokey")
    public String produceNoKeyMessage(@RequestParam(value = "key",defaultValue = "default_key") String key, @RequestParam(value = "message", defaultValue = "default message") String message) {
        senderService.send(message);
        return String.format("Msg sent Key:No Key -  Content:%s ", message);
    }

    @GetMapping(value="/send/errors")
    public String produceErrorMessage(){
        String message = "errormessagem";
        senderService.send(message);
        return String.format("Msg sent Key:Error Msg -  Content:%s ", message);
    }
}
