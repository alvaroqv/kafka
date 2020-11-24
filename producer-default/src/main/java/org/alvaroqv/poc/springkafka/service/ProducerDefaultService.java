package org.alvaroqv.poc.springkafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerDefaultService {

    private Logger logger = LoggerFactory.getLogger(ProducerDefaultService.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${spring.kafka.topic}")
    private String topic;

    public void send(String content) {
        logger.info("Sending message='{}' to topic='{}'", content, topic);
        kafkaTemplate.send(topic, content);
    }


    public void send(String key, String content) {
        logger.info("Sending message key='{}' content'{}' to topic='{}'", key, content, topic);
        kafkaTemplate.send(topic, key, content);
    }
}
