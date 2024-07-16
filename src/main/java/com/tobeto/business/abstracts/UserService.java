package com.tobeto.business.abstracts;

import java.util.UUID;

import com.tobeto.dtos.PageResponse;
import com.tobeto.dtos.users.GetAllUserResponse;
import com.tobeto.entities.concretes.User;

public interface UserService {
   
	PageResponse<GetAllUserResponse> getAllUserResponse();
	User getAuthenticatedUser();
	User getUser(UUID userId);
}
