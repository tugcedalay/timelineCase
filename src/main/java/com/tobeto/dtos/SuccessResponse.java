package com.tobeto.dtos;

import com.tobeto.core.utilities.exceptions.Messages;

import lombok.Data;

@Data
public class SuccessResponse {
	private String message = Messages.SUCCESSFULLY;
}
