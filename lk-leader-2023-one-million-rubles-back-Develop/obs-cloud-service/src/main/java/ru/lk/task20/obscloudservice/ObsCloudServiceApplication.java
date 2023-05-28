package ru.lk.task20.obscloudservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ObsCloudServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObsCloudServiceApplication.class, args);
	}

}
