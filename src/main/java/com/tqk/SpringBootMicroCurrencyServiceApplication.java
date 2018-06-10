package com.tqk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@RibbonClient(name = "forex-service", configuration = ForexConfiguration.class)
public class SpringBootMicroCurrencyServiceApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringBootMicroCurrencyServiceApplication.class, args);
		
	}
}
