package com.student.Task.Management.Web.Application.controller;

import java.util.List;

import com.student.Task.Management.Web.Application.expcation.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.student.Task.Management.Web.Application.Services.Impl.TaskMangerImpl;
import com.student.Task.Management.Web.Application.model.Task;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskMangerImpl taskMangerImpl;
    @Autowired
    private TaskMangerImpl taskManger;

    @PostMapping("/")
    public ResponseEntity<Task> saveTask(@Valid @RequestBody Task task) {
        Task createTask = this.taskManger.createTask(task);
        return new ResponseEntity<Task>(createTask, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Integer id) {
        Task task = this.taskMangerImpl.getTask(id);
        return new ResponseEntity<Task>(task, HttpStatus.OK);

    }


    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTask() {
        List<Task> getTask = this.taskMangerImpl.allTask();
        return ResponseEntity.ok(getTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteTask(@PathVariable Integer id) {
        this.taskMangerImpl.deleteTask(id);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Task is deleted successfully !!", true),
                HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@Valid @RequestBody Task task,
                                                      @PathVariable Integer id) {
        Task updateTask = this.taskMangerImpl.updateTask(task, id);
        return new ResponseEntity<Task>(updateTask, HttpStatus.OK);
    }

}
