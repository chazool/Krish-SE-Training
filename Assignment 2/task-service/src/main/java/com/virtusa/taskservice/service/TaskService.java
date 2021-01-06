package com.virtusa.taskservice.service;

import com.virtusa.common.Task;
import com.virtusa.taskservice.exception.TaskIdNullPointerException;

import java.util.List;

public interface TaskService {

    String save(Task task);

    String update(int id, Task task) throws TaskIdNullPointerException;

    Task findById(int id);

    List<Task> findAll();

    String delete(int id);


}
