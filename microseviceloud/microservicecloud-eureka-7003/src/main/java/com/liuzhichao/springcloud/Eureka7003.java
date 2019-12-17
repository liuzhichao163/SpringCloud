package com.liuzhichao.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eureka7003 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Eureka7003.class, args);
	}

}
