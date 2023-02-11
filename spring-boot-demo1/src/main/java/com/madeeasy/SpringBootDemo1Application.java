package com.madeeasy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringBootDemo1Application {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemo1Application.class, args);
	}

}
