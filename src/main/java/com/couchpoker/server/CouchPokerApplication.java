package com.couchpoker.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class CouchPokerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouchPokerApplication.class, args);
    }

}
