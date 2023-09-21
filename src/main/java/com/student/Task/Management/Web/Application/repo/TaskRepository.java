package com.student.Task.Management.Web.Application.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.Task.Management.Web.Application.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{

}
