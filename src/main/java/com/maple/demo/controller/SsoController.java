package com.maple.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sso")
public class SsoController {

	@PostMapping(value = "/login")
	public String login(String username, String password) {
		System.out.println(username);
		System.out.println(password);
		return "aaa";
	}
}
