package com.tobeto.entities.concretes;

import com.tobeto.entities.abstracts.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "work_hours")
@EqualsAndHashCode(callSuper = true)
public class WorkHours extends BaseEntity{
  
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@Column(name = "starter_time")
	private String starterTime;
	
	@Column(name = "end_time")
	private String endTime;
	
	@Column(name = "work_date")
	private String workDate;
	
}
