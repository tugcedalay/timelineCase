package com.tobeto.business.concretes;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobeto.business.abstracts.UserService;
import com.tobeto.business.rules.user.UserBusinessRules;
import com.tobeto.core.utilities.config.mappers.ModelMapperService;
import com.tobeto.dataAccess.UserRepository;
import com.tobeto.dtos.PageResponse;
import com.tobeto.dtos.users.GetAllUserResponse;
import com.tobeto.entities.concretes.User;

@Service
public class UserManager implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserBusinessRules userBusinessRules;

	@Autowired
	private ModelMapperService modelMapper;

	@Override
	public PageResponse<GetAllUserResponse> getAllUserResponse() {
		
		List<User> users = userRepository.findAll();

		List<GetAllUserResponse> responseUsers = users.stream()
				.map(user -> modelMapper.forResponse().map(user, GetAllUserResponse.class)).toList();

		int userCount = responseUsers.size();
		return new PageResponse<GetAllUserResponse>(userCount, responseUsers);
	}
	@Override
	public User getAuthenticatedUser() {
		User user = userBusinessRules.getCurrentUser();
		return user;
	}
	
	@Override
	public User getUser(UUID userId) {
		return userBusinessRules.checkUserExistsById(userId);
	}
}
