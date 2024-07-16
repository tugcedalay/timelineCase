package com.tobeto.business.abstracts;

import com.tobeto.dtos.PageResponse;
import com.tobeto.dtos.SuccessResponse;
import com.tobeto.dtos.workhours.CreateWorkHourRequest;
import com.tobeto.dtos.workhours.GetTotalWorkHour;
import com.tobeto.dtos.workhours.GetWorkHourForUserResponse;

public interface WorkHoursService {

	SuccessResponse createWorkHour(CreateWorkHourRequest request);

	GetTotalWorkHour getTotalWorkHour();

	PageResponse<GetWorkHourForUserResponse> getWorkHourForUserResponse();

}
