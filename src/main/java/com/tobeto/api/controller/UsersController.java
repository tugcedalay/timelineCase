package com.tobeto.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.business.abstracts.UserService;
import com.tobeto.dtos.PageResponse;
import com.tobeto.dtos.users.GetAllUserResponse;

@RestController
@RequestMapping("api/v1/users")
public class UsersController {
	@Autowired
	private UserService userService;

	@GetMapping("/getall")
	public PageResponse<GetAllUserResponse> getAll() {
		return userService.getAllUserResponse();
	}
}
