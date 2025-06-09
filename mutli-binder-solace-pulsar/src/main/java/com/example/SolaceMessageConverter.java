package com.example;

import org.springframework.messaging.converter.AbstractMessageConverter;

public class SolaceMessageConverter extends AbstractMessageConverter {
    @Override
    protected boolean supports(Class<?> clazz) {
        return false;
    }
}
