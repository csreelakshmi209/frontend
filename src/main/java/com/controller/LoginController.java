package com.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dto.LoginDto;
import com.exception.InvalidCredentialsException;
import com.model.Employee;
import com.model.Login;
import com.service.ILoginService;



@CrossOrigin
@RestController
public class LoginController {
	@Autowired
	ILoginService loginService;
	
	private static Logger logger = LogManager.getLogger();
	
	@PostMapping("/login")
	public ResponseEntity<LoginDto> login(@RequestBody Login login) throws InvalidCredentialsException {
		LoginDto dto = loginService.login(login);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	@PatchMapping("/logout/{username}")
	public ResponseEntity<LoginDto> logout(@PathVariable("username") String username) throws InvalidCredentialsException  {
		logger.info(username);
		LoginDto dto = loginService.logout(username);
		return new ResponseEntity<>(dto, HttpStatus.OK);
	}
	
	
	

}
