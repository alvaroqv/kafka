package org.alvaroqv.poc.springkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerRetryBlockingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerRetryBlockingApplication.class, args);
    }
}
