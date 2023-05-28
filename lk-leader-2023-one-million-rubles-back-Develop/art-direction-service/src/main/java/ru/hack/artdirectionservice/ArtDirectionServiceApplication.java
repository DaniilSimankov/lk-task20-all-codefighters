package ru.hack.artdirectionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ArtDirectionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArtDirectionServiceApplication.class, args);
	}

}
