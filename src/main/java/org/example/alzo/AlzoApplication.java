package org.example.alzo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RequestMapping("/alzo/api/v2")
public class AlzoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlzoApplication.class, args);
    }



}
