package org.alvaroqv.poc.springkafka.model;

import lombok.Data;

@Data
public class MessageDto {

    private Integer id;
    private String message;

    public MessageDto(Integer id, String message) {
        this.id = id;
        this.message = message;
    }


}
