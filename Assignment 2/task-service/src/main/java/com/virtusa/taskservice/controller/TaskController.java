package com.virtusa.taskservice.controller;

import com.virtusa.common.Task;
import com.virtusa.taskservice.exception.InvalidProjectException;
import com.virtusa.taskservice.exception.TaskIdNullPointerException;
import com.virtusa.taskservice.service.TaskService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/service/task")
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private RestTemplate restTemplate;


    @PostMapping
    public String save(@RequestBody Task task) {
        try {
            return taskService.save(task);
        } catch (TaskIdNullPointerException taskIdNullPointerException) {
            return taskIdNullPointerException.getMessage();
        } catch (InvalidProjectException invalidProjectException) {
            return invalidProjectException.getMessage();
        } catch (HttpClientErrorException httpClientErrorException) {
            return "unavailable project service or ProjectId";
        }
    }

    @PutMapping("/{id}")
    public String update(@RequestBody Task task, @PathVariable int id) {
        try {
            return taskService.update(id, task);
        } catch (TaskIdNullPointerException taskIdNullPointerException) {
            return taskIdNullPointerException.getMessage();
        } catch (InvalidProjectException invalidProjectException) {
            return invalidProjectException.getMessage();
        } catch (HttpClientErrorException httpClientErrorException) {
            return "unavailable project service or ProjectId";
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        try {
            return taskService.delete(id);
        } catch (TaskIdNullPointerException taskIdNullPointerException) {
            return taskIdNullPointerException.getMessage();
        } catch (HttpClientErrorException httpClientErrorException) {
            return "unavailable project service or ProjectId";
        }
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable int id) {
        return taskService.findById(id);
    }

    @GetMapping("/project/{projectId}")
    public JSONObject getTaskByProjectId(@PathVariable int projectId) {
        List<Task> tasks = null;
        String message = null;
        try {
            tasks = taskService.findByProjectId(projectId);
        } catch (InvalidProjectException invalidProjectException) {
            message = invalidProjectException.getMessage();
        } catch (HttpClientErrorException httpClientErrorException) {
            message = "unavailable project service or ProjectId";
        } catch (Exception e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Tasks", tasks);
        jsonObject.put("message", message);

        return jsonObject;
    }

}
