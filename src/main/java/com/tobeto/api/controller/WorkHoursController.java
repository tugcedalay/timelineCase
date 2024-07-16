package com.tobeto.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tobeto.business.abstracts.WorkHoursService;
import com.tobeto.dtos.PageResponse;
import com.tobeto.dtos.SuccessResponse;
import com.tobeto.dtos.workhours.CreateWorkHourRequest;
import com.tobeto.dtos.workhours.GetTotalWorkHour;
import com.tobeto.dtos.workhours.GetWorkHourForUserResponse;

@RestController
@RequestMapping("api/v1/workhours")
public class WorkHoursController {

	@Autowired
	private WorkHoursService workHoursService;

	@PostMapping("/create")
	public SuccessResponse createWorkHour(@RequestBody CreateWorkHourRequest request) {

		return workHoursService.createWorkHour(request);

	}

	@GetMapping("/totalworkhour")
	public GetTotalWorkHour getTotalWorkHour() {
		return workHoursService.getTotalWorkHour();
	}

	@GetMapping("/getworkhour")
	public PageResponse<GetWorkHourForUserResponse> getWorkHourForUserResponse() {
		return workHoursService.getWorkHourForUserResponse();
	}
}
