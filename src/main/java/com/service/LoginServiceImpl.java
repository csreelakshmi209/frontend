package com.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.dto.LoginDto;
import com.exception.InvalidCredentialsException;
import com.model.Login;
import com.repository.LoginRepository;

@Service
public class LoginServiceImpl implements ILoginService{

	@Autowired
	LoginRepository loginRepo;
	
	private static Logger logger = LogManager.getLogger();
	@Override
	public LoginDto login(Login login) throws InvalidCredentialsException {
		Optional<Login> opt = loginRepo.findByUsername(login.getUsername());
		
		if(!opt.isPresent()) {
			throw new InvalidCredentialsException("Invalid Credentials");
		}
		Login dbLogin = opt.get();
		if(login.getUsername().equalsIgnoreCase(dbLogin.getUsername()) && 
				login.getPassword().equalsIgnoreCase(dbLogin.getPassword())  && 
				login.getRole().equalsIgnoreCase(dbLogin.getRole())) {
			// set isLoggedIn flag to true
			dbLogin.setLoggedIn(true);
			
			// update isLoggedIn flag to true 
			loginRepo.save(dbLogin);
			LoginDto dto = new LoginDto();
			dto.setUsername(login.getUsername());
			dto.setRole(login.getRole());
			dto.setLoggedIn(true);
			
			return dto;
		} else {
			throw new InvalidCredentialsException("Invalid credentials");
		}
		
	}

	@Override
	public LoginDto logout(String username) throws InvalidCredentialsException {
		
		logger.info(username);
		Optional<Login> opt = loginRepo.findByUsername(username);
		if(!opt.isPresent()) {
			throw new InvalidCredentialsException("Invalid Credentials");
		}
		Login login= opt.get();
		logger.info(login.getUsername());
		login.setLoggedIn(false);
		loginRepo.save(login);
		LoginDto loginDto = new LoginDto();
		loginDto.setLoggedIn(false);
		return loginDto;
	}


}
