package com.tobeto.dtos.workhours;

import lombok.Data;

@Data
public class GetWorkHourForUserResponse {
  
	private String starterDate;
  
	private String endDate;
	
	private String workDate;
}
