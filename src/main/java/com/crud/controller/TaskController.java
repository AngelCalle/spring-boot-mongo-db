package com.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.crud.dto.TaskDTO;
import com.crud.entity.Task;
import com.crud.mapper.TaskMapper;
import com.crud.service.impl.TaskServiceImpl;

import lombok.RequiredArgsConstructor;

@CrossOrigin
@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
public class TaskController {
	
	private final TaskServiceImpl taskService;
	
	// http://localhost:8080/task
	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	public List<Task> findall() {
		return taskService.findAll();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("{id}")
	public Optional<Task> findById(@PathVariable String id) {
		return taskService.findById(id);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public Task save(@RequestBody TaskDTO taskDTO) {
		return taskService.save(TaskMapper.toTask(taskDTO));
	}
	
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PutMapping("{id}")
	public Task update(@PathVariable String id, @RequestBody TaskDTO taskDTO) {
		return taskService.update(id, TaskMapper.toTask(taskDTO));
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	public void delete(@PathVariable String id) {
		taskService.delete(id);
	}

}
