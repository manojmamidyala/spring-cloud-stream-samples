package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class MultiBinderApp {

    public static void main( String[] args ) {
        SpringApplication.run(MultiBinderApp.class, args);
    }

    @Bean
    public Supplier<UUID> uuidSupplier() {
        return () -> {
            var uuid = UUID.randomUUID();
            System.out.println("Produced: " + uuid);
            return uuid;
        };
    }

    @Bean
    public Function<String, String> digitRemovingConsumer() {
        return uuid -> {
            System.out.println("digitRemovingConsumer consumed: " + uuid);
            String strUUID = uuid.replaceAll("\\d","");
            System.out.println("digitRemovingConsumer produced: " + strUUID);
            return strUUID;
        };
    }

    @Bean
    public Consumer<String> uuidConsumer() {
        return uuid -> System.out.println("Consumed: " + uuid);
    }

}
