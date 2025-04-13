package com.example.bruteforceauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.example.bruteforceauth")
public class BruteforceAuthApplication {

	public static void main(String[] args) {

		SpringApplication.run(BruteforceAuthApplication.class, args);
	}
}