package org.alvaroqv.poc.springkafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerRetryNonBlockingService {

    private Logger logger = LoggerFactory.getLogger(ConsumerRetryNonBlockingService.class);

    @KafkaListener(topics = "${spring.kafka.topic}")
    public void Handle(String message){

        logger.info("Message: {} , Origin: {}", message, ConsumerRetryNonBlockingService.class.getSimpleName());
        System.out.println(message);
    }
}
