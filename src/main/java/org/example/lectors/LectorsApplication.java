package org.example.lectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class LectorsApplication {

    public static void main(String[] args) {
        SpringApplication.run(LectorsApplication.class, args);
    }

}
