package com.tobeto.business.abstracts;

import com.tobeto.dtos.login.LoginRequest;
import com.tobeto.dtos.login.LoginResponse;

public interface LoginService {
   
	LoginResponse login(LoginRequest request);
}
