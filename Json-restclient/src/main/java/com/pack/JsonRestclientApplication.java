package com.pack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@ComponentScans({@ComponentScan("com.pack.model"),@ComponentScan("com.pack.controller"),@ComponentScan("com.pack.business")})
public class JsonRestclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(JsonRestclientApplication.class, args);
	}

}
