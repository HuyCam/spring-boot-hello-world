package com.example.springhelloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Properties;


@SpringBootApplication
public class SpringHelloWorldApplication {

	public static void main(String[] args) {

		System.exit(SpringApplication.exit(SpringApplication.run(SpringHelloWorldApplication.class, args)));

	}

}
