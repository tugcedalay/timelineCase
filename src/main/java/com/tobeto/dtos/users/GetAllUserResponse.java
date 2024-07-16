package com.tobeto.dtos.users;

import java.util.UUID;

import lombok.Data;

@Data
public class GetAllUserResponse {

	private UUID id;

	private String username;

	private String email;
}
