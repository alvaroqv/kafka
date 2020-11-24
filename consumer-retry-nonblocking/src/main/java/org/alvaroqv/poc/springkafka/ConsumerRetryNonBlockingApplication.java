package org.alvaroqv.poc.springkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerRetryNonBlockingApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerRetryNonBlockingApplication.class, args);
    }
}
