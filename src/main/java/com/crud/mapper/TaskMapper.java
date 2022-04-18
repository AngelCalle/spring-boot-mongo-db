package com.crud.mapper;

import com.crud.dto.TaskDTO;
import com.crud.entity.Task;

public class TaskMapper {

	public static Task toTask(TaskDTO dto) {
		Task task = new Task();
		task.setId(dto.getId());
		task.setName(dto.getName());
		task.setFinalized(task.isFinalized());
		return task;
	}
	
	public TaskDTO toDto(Task dask) {
		TaskDTO dto = new TaskDTO();
		dto.setId(dask.getId());
		dto.setName(dask.getName());
		dto.setFinalized(dask.isFinalized());
		return dto;
	}

}
