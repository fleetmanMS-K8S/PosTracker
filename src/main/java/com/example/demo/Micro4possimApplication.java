package com.example.demo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableRabbit
public class Micro4possimApplication {

	public static void main(String[] args) {
		SpringApplication.run(Micro4possimApplication.class, args);
	}

}
