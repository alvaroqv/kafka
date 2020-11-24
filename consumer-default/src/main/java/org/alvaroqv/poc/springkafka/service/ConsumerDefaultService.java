package org.alvaroqv.poc.springkafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ConsumerDefaultService {

    private Logger logger = LoggerFactory.getLogger(ConsumerDefaultService.class);
    private Map<String, String> messagesResponse = new LinkedHashMap<String, String>();
    final private AtomicInteger count = new AtomicInteger(0);

    public String showMessages(){
        StringBuilder messageReader = new StringBuilder();

        messagesResponse.forEach((k,v)->{
            messageReader.append(String.format("Key %s - Value: %s <br>", String.valueOf(k), String.valueOf(v)));
        });
        return messageReader.toString();
    }

    @KafkaListener(topics = "${spring.kafka.topic}")
    public void Handle(final ConsumerRecord consumerRecord){
        logger.info("key: " + consumerRecord.key());
        logger.info("Headers: " + consumerRecord.headers());
        logger.info("Partion: " + consumerRecord.partition());
        logger.info("Offset: " + consumerRecord.offset());
        logger.info("Value: " + consumerRecord.value());
        messagesResponse.put(count.getAndIncrement()+ " - " + Optional.ofNullable(consumerRecord.key()).orElse("No Key").toString(),consumerRecord.value().toString());
      //  acknowledgment.acknowledge();
        logger.info("acknowledgment: Done") ;
    }

    public void cleanCache() {
        messagesResponse.clear();;
    }
}
