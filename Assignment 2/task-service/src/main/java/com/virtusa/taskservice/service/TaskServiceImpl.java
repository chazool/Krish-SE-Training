package com.virtusa.taskservice.service;

import com.virtusa.common.Project;
import com.virtusa.common.Task;
import com.virtusa.taskservice.exception.InvalidProjectException;
import com.virtusa.taskservice.exception.TaskIdNullPointerException;
import com.virtusa.taskservice.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String save(Task task) throws InvalidProjectException, HttpClientErrorException {
        if (isActiveProject(task.getProjectId())) {
            //Create Active Task
            task.setActive(true);

            if (Optional.of(taskRepository.save(task)).isPresent()) {
                return "Id: " + task.getId() + " Save Successful";
            } else {
                return "Save Unsuccessful";
            }
        } else {
            throw new InvalidProjectException("Invalid Project Id");
        }

    }

    @Override
    public String update(int id, Task task) throws TaskIdNullPointerException, HttpClientErrorException {

        if (id <= 0) {
            throw new TaskIdNullPointerException("Invalid Task Id");
        }
        //is Valid Project Id
        else if (isActiveProject(task.getProjectId()) == false) {
            throw new InvalidProjectException("Invalid Project Id");
        } else {
            task.setId(id);
            if (Optional.of(taskRepository.save(task)).isPresent()) {
                return "Update Successful";
            } else {
                return "Update Unsuccessful";
            }
        }

    }

    @Override
    public String delete(int id) throws TaskIdNullPointerException, HttpClientErrorException {

        if (id <= 0) {
            throw new TaskIdNullPointerException("Invalid Task Id");
        } else {
            Task task = new Task();
            task.setId(id);
            task.setActive(false);

            if (Optional.of(taskRepository.save(task)).isPresent()) {
                return "Delete Successful";
            } else {
                return "Delete Unsuccessful";
            }
        }


    }

    @Override
    public Task findById(int id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent())
            return task.get();
        else
            return null;

    }


    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> findByProjectId(int projectId) throws InvalidProjectException, HttpClientErrorException {
        if (isActiveProject(projectId)) {
            return taskRepository.findByProjectId(projectId);
        } else {
            throw new InvalidProjectException("Invalid Project Id");
        }
    }

    /*
    Active = True
    deactivate false
     */
    private boolean isActiveProject(int projectId) throws HttpClientErrorException {
        // Project Service
        Boolean isAvailable = false;

        isAvailable = restTemplate.getForObject("http://localhost:8081/service/project/isAvailable/" + projectId, Boolean.class);
        return isAvailable;
    }
}
