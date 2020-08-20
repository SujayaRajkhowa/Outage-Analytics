package com.example.spring.boot.OutageAnalytics_UserRegistration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan
@SpringBootApplication
public class OutageAnalyticsUserRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(OutageAnalyticsUserRegistrationApplication.class, args);
	}

}
