package com.xyz.controllers;

import com.xyz.dto.WelcomeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ebm-demo/api/v1/json")
public class WelcomeController {

	@GetMapping(value = "/welcomeMessage")
	public ResponseEntity<WelcomeDto> helloWorld() {
		WelcomeDto welcomeDto = new WelcomeDto();
		welcomeDto.setMessage1("Hello World !!!!!!");
		welcomeDto.setMessage2("Test API for demo");
		return new ResponseEntity<WelcomeDto>(welcomeDto,HttpStatus.OK);
	}
}
