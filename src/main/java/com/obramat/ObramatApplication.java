package com.obramat;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ObramatApplication {

    private static final Logger log = LoggerFactory.getLogger(ObramatApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ObramatApplication.class, args);
    }
}
