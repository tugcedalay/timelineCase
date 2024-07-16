package com.tobeto.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tobeto.business.abstracts.UserService;
import com.tobeto.business.abstracts.WorkHoursService;
import com.tobeto.business.rules.workHour.WorkHourBusinessRule;
import com.tobeto.core.utilities.config.mappers.ModelMapperService;
import com.tobeto.dataAccess.WorkHoursRepository;
import com.tobeto.dtos.PageResponse;
import com.tobeto.dtos.SuccessResponse;
import com.tobeto.dtos.workhours.CreateWorkHourRequest;
import com.tobeto.dtos.workhours.GetTotalWorkHour;
import com.tobeto.dtos.workhours.GetWorkHourForUserResponse;
import com.tobeto.entities.concretes.User;
import com.tobeto.entities.concretes.WorkHours;

@Service
public class WorkHoursManager implements WorkHoursService {

	@Autowired
	private WorkHourBusinessRule workHourBusinessRule;

	@Autowired
	private UserService userService;

	@Autowired
	private ModelMapperService modelMapper;

	@Autowired
	private WorkHoursRepository workHoursRepository;

	@Override
	public SuccessResponse createWorkHour(CreateWorkHourRequest request) {
		User authenticatedUser = userService.getAuthenticatedUser();
		String localDate = workHourBusinessRule.formattedLocalDate();
		WorkHours workHour = modelMapper.forRequest().map(request, WorkHours.class);
		workHour.setUser(authenticatedUser);
		workHour.setWorkDate(localDate);
		workHoursRepository.save(workHour);
		return new SuccessResponse();
	}

	@Override
	public GetTotalWorkHour getTotalWorkHour() {
		User authenticatedUser = userService.getAuthenticatedUser();

		List<WorkHours> workHours = workHoursRepository.findWorkHourByUserId(authenticatedUser.getId());

		String totalWorkTime = workHourBusinessRule.calculationWorkHour(workHours);

		return new GetTotalWorkHour(totalWorkTime);
	}

	@Override
	public PageResponse<GetWorkHourForUserResponse> getWorkHourForUserResponse() {
		User authenticatedUser = userService.getAuthenticatedUser();
		List<WorkHours> workHours = workHoursRepository.findWorkHourByUserId(authenticatedUser.getId());

		List<GetWorkHourForUserResponse> pageResponses = workHours.stream()
				.map(pageResponse -> modelMapper.forResponse().map(pageResponse, GetWorkHourForUserResponse.class))
				.toList();
		int count = pageResponses.size();

		return new PageResponse<GetWorkHourForUserResponse>(count, pageResponses);
	}

}
