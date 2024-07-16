package com.tobeto.business.rules.workHour;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tobeto.entities.concretes.WorkHours;

@Service
public class WorkHourBusinessRule {
	
	public String formattedLocalDate() {
		LocalDate now = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd"); 
		String formattedDate = now.format(formatter);
		return formattedDate; 
	}
	
	public String calculationWorkHour(List<WorkHours> workHours) {
		Duration totalDuration = Duration.ZERO;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        
        for (WorkHours workHour : workHours) {
            LocalTime startTime = LocalTime.parse(workHour.getStarterTime(), formatter);
            LocalTime endTime = LocalTime.parse(workHour.getEndTime(), formatter);
            Duration duration = Duration.between(startTime, endTime);
            totalDuration = totalDuration.plus(duration);
        }
        
        long totalHours = totalDuration.toHours();
        long totalMinutes = totalDuration.toMinutes() % 60;
        long totalSeconds = totalDuration.getSeconds() % 60;
        
        String totalWorkTime = String.format("%02d:%02d:%02d", totalHours, totalMinutes, totalSeconds);
		
        return totalWorkTime;
	}

}
