package com.doranco.inscicecom.services.auth;

import com.doranco.inscicecom.dto.SignupRequest;
import com.doranco.inscicecom.dto.UserDto;

public interface AuthService {
	UserDto createUser(SignupRequest signupRequest);

	Boolean hasUserWithEmail(String email);

	void createAdminAccount();
}
