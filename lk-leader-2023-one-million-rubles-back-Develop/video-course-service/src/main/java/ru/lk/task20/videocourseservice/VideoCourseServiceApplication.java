package ru.lk.task20.videocourseservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class VideoCourseServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideoCourseServiceApplication.class, args);
    }

}
