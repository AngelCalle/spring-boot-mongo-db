package com.crud.service;

import java.util.List;
import java.util.Optional;

import com.crud.entity.Task;

public interface TaskService {
	
	List<Task> findAll();
	
	Optional<Task> findById(String id);
	
	Task save(Task task);
	
	Task update(String id, Task task);
	
	void delete(String id);

}
