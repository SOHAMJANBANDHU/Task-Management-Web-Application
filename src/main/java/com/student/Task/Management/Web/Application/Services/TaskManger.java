package com.student.Task.Management.Web.Application.Services;

import com.student.Task.Management.Web.Application.model.Task;

import java.util.List;

public interface TaskManger {
    Task saveTask(Task task);

    Task createTask(Task task);
    Task getTask(Integer id);
    List<Task> allTask();
    void deleteTask(Integer id);
    Task updateTask(Task task,Integer id);
}
