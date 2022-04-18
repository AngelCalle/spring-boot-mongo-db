package com.crud.dto;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class TaskDTO {
	
	@Id
	private String id;
	private String name;
	private boolean isFinalized;

}
