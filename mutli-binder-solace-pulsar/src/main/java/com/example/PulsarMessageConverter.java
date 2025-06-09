package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.support.GenericMessage;

import java.util.Map;

public class PulsarMessageConverter implements MessageConverter {

    private static final Logger log = LoggerFactory.getLogger(PulsarMessageConverter.class);

    @Override
    public Object fromMessage(Message<?> message, Class<?> targetClass) {
        // log.info(message.getHeaders().toString());
        return new String((byte[]) message.getPayload());
    }

    @Override
    public Message<?> toMessage(Object payload, MessageHeaders headers) {
        // log.info(headers.toString());
        MessageHeaders messageHeaders = new MessageHeaders(Map.of());
        Message<String> stringMessage = new GenericMessage<>(payload.toString(), messageHeaders);
        return stringMessage;
    }

}
