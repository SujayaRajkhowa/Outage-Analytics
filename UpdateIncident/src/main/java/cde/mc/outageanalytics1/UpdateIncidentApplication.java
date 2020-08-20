package cde.mc.outageanalytics1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
@EntityScan(basePackages = {"cde.mc.outageanalytics1.entity"})
public class UpdateIncidentApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpdateIncidentApplication.class, args);
	}

}
