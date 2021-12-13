package com.service;

import org.springframework.stereotype.Service;

import com.dto.LoginDto;
import com.exception.InvalidCredentialsException;
import com.model.Login;

@Service
public interface ILoginService {
	
	LoginDto login(Login login) throws InvalidCredentialsException;
	LoginDto logout(String userId) throws InvalidCredentialsException;

}
