package com.crud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.crud.entity.Task;
import com.crud.repository.ITaskRepository;
import com.crud.service.TaskService;

import lombok.RequiredArgsConstructor;

@Service
@Validated
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

	private final ITaskRepository taskRepository;

	@Override
	public List<Task> findAll() {
		return taskRepository.findAll();
	}

	@Override
	public Task save(Task task) {
		return taskRepository.save(task);
	}
	
	@Override
	public Optional<Task> findById(String id) {
		return taskRepository.findById(id);
	}

	@Override
	public Task update(String id, Task task) {
		Task taskDB = taskRepository.findById(id).orElseThrow(RuntimeException::new);
		taskDB.setName(task.getName());
		taskDB.setFinalized(task.isFinalized());
		return taskRepository.save(taskDB);
	}

	@Override
	public void delete(String id) {
		Task taskDB = taskRepository.findById(id).orElseThrow(RuntimeException::new);
		taskRepository.delete(taskDB);		
	}

}
