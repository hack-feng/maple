package com.maple.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.maple.demo")
public class MapleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapleApplication.class, args);
	}
	
}
