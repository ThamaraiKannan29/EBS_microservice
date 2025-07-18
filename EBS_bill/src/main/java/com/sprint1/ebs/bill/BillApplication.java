package com.sprint1.ebs.bill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class BillApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillApplication.class, args);
		
		
	}
	@Bean
    public RestTemplate template() {
        return new RestTemplate();
    }

}
