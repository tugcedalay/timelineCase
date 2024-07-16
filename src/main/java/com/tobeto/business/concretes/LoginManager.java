package com.tobeto.business.concretes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobeto.business.abstracts.LoginService;
import com.tobeto.business.rules.user.UserBusinessRules;
import com.tobeto.core.utilities.config.jwt.JwtConfig;
import com.tobeto.dtos.login.LoginRequest;
import com.tobeto.dtos.login.LoginResponse;
import com.tobeto.entities.concretes.User;

@Service
public class LoginManager implements LoginService{
    
	@Autowired
	private JwtConfig jwtConfig;
	
	@Autowired
	private UserBusinessRules userBusinessRules;
	
	@Override
	public LoginResponse login(LoginRequest request) {
	   Optional<User> user = userBusinessRules.checkUserExists(request.getUsername());	
	   userBusinessRules.checkPassword(user.get(), request.getPassword());
	   String token = jwtConfig.createToken(user.get());
		return new LoginResponse(token);
	}

}
