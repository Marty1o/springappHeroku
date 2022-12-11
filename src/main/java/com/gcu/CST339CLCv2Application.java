package com.gcu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.gcu"})
public class CST339CLCv2Application {

	public static void main(String[] args) {
		SpringApplication.run(CST339CLCv2Application.class, args);
	}

}
