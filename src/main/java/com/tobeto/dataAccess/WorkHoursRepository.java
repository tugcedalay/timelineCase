package com.tobeto.dataAccess;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tobeto.entities.concretes.WorkHours;

public interface WorkHoursRepository extends JpaRepository<WorkHours, UUID>{
   
	List<WorkHours> findWorkHourByUserId(UUID userId);
   
}
