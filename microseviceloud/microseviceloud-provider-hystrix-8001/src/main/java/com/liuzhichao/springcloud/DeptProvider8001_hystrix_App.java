package com.liuzhichao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker  //对hystrix融断机制的支持
public class DeptProvider8001_hystrix_App {
	public static void main(String[] args) {
		SpringApplication.run(DeptProvider8001_hystrix_App.class, args);
	}

}
