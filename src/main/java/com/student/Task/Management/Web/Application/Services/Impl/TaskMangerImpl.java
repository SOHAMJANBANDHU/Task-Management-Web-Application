package com.student.Task.Management.Web.Application.Services.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.student.Task.Management.Web.Application.Services.TaskManger;
import com.student.Task.Management.Web.Application.expcation.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.student.Task.Management.Web.Application.model.Task;
import com.student.Task.Management.Web.Application.repo.TaskRepository;

@Repository
public class TaskMangerImpl implements TaskManger {

	@Autowired
	private ModelMapper modelMapper;
	@Autowired
	private TaskRepository repository;

	public Task saveTask(Task task) {
		return repository.save(task);
	}

	@Override
	public Task createTask(Task task) {
		Task task1 = this.modelMapper.map(task, Task.class);
		Task task2 = this.repository.save(task1);
		return this.modelMapper.map(task2, Task.class);
	}
	@Override
	public Task getTask(Integer id) {
		Task cat = this.repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Get Task", "Task id", id));
		return this.modelMapper.map(cat, Task.class);
	}
	@Override
	public List<Task> allTask() {
		List<Task> tasks = this.repository.findAll();
		List<Task> tasks1 = tasks.stream().map((id) -> this.modelMapper.map(id, Task.class))
				.collect(Collectors.toList());

		return tasks1;
	}
	@Override
	public void deleteTask(Integer id) {
		Task cat = this.repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Delete Task ", "Task id", id));
		this.repository.delete(cat);

	}

	@Override
	public Task updateTask(Task task, Integer id) {
		Task task1 = this.repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("UpdateTask ", "Task id", id));

		task1.setTitle(task.getTitle());
		task1.setDescription(task.getDescription());
		task1.setStatus(task.getStatus());

		Task task2 = this.repository.save(task1);

		return this.modelMapper.map(task2, Task.class);
	}
}
