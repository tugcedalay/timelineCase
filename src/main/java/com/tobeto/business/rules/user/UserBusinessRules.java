package com.tobeto.business.rules.user;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tobeto.core.utilities.AuthenticatedUser;
import com.tobeto.core.utilities.exceptions.BusinessException;
import com.tobeto.core.utilities.exceptions.Messages;
import com.tobeto.dataAccess.UserRepository;
import com.tobeto.entities.concretes.User;

@Service
public class UserBusinessRules {
    
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public User checkUserExistsById(UUID userId) {
		
		User user = userRepository.findById(userId).orElseThrow(() -> new BusinessException(Messages.USER_NOT_FOUND));
		
		return user;
	}
	
	public Optional<User> checkUserExists(String username){
		Optional<User> user = userRepository.findByUsername(username);
		
		if (!user.isPresent()) {
			 
			throw new BusinessException(Messages.USER_NOT_FOUND);
		}
		
		return user;
	}
	
	public boolean checkPassword(User user, String password) {
		
		if(passwordEncoder.matches(password, user.getPassword())) {
			return true;
		}
		
		else {
			throw new BusinessException(Messages.WRONG_PASSWORD);
		}
	}
	
	public User getCurrentUser() {
		String authenticatedEmail = AuthenticatedUser.getCurrentUser();
		User currentUser = userRepository.findByEmail(authenticatedEmail);
		if (currentUser.getEmail().equals(authenticatedEmail)) {
			return currentUser;
		} else {
			throw new BusinessException(Messages.AUTHENTICATED_USER_NOT_FOUND);
		}
	}
}
