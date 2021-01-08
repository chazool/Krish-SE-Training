package com.virtusa.taskservice.service;

import com.virtusa.common.taskservice.Task;
import com.virtusa.taskservice.exception.InvalidProjectException;
import com.virtusa.taskservice.exception.ProjectServiceException;
import com.virtusa.taskservice.exception.TaskIdNullPointerException;
import com.virtusa.taskservice.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

/***
 * @author chazool
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private RestTemplate restTemplate;

    /***
     * {@inheritDoc}
     * before save set IsActive ture
     * @param task
     * @return Task
     * @throws InvalidProjectException
     * @throws HttpClientErrorException
     */
    @Override
    public Task save(Task task) throws InvalidProjectException, HttpClientErrorException {
        if (isActiveProject(task.getProjectId())) {
            //Create Active Task
            task.setActive(true);
            return taskRepository.save(task);
        } else {
            throw new InvalidProjectException("Invalid Project Id");
        }

    }

    /**
     * before update insert Task Id to Task Object
     *
     * @param id
     * @param task
     * @return Task
     * @throws TaskIdNullPointerException
     * @throws HttpClientErrorException
     */
    @Override
    public Task update(int id, Task task) throws TaskIdNullPointerException, HttpClientErrorException {
        if (id <= 0) {
            throw new TaskIdNullPointerException("Invalid Task Id");
        }
        //is Valid Project Id
        else if (isActiveProject(task.getProjectId()) == false) {
            throw new InvalidProjectException("Invalid Project Id");
        } else {
            task.setId(id);
            return taskRepository.save(task);
        }

    }

    /***
     *{@inheritDoc}
     * @param id
     * @return Task
     * @throws TaskIdNullPointerException
     * @throws HttpClientErrorException
     */
    @Override
    public Task delete(int id) throws TaskIdNullPointerException, HttpClientErrorException {

        if (id <= 0) {
            throw new TaskIdNullPointerException("Invalid Task Id");
        } else {
            return taskRepository.deactivateTask(id) == 1 ? taskRepository.findById(id).get() : null;
        }
    }

    /***
     * {@inheritDoc}
     * @param id
     * @return Task
     */
    @Override
    public Task findById(int id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent())
            return task.get();
        else
            return null;
    }

    /***
     *{@inheritDoc}
     * The Method for Fetch All Tasks
     * @return List<Task>
     */
    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    /***
     *{@inheritDoc}
     * The method for fetch all Task by Project ID
     * @param projectId
     * @return List<Task>
     * @throws InvalidProjectException
     * @throws HttpClientErrorException
     */
    @Override
    public List<Task> findByProjectId(int projectId) throws InvalidProjectException, HttpClientErrorException {
        if (isActiveProject(projectId)) {
            return taskRepository.findByProjectId(projectId);
        } else {
            throw new InvalidProjectException("Invalid Project Id");
        }
    }

    /***
     *
     * @param projectId
     * @return boolean
     *     -  Active = True
     *        deactivate false
     * @throws HttpClientErrorException
     */
    private boolean isActiveProject(int projectId) throws HttpClientErrorException {
        // Project Service
        try {
            return restTemplate.getForObject("http://localhost:8081/service/project/isAvailable/" + projectId, Boolean.class);

        } catch (HttpClientErrorException httpClientErrorException) {
            throw new ProjectServiceException("unavailable project service or ProjectId" + "/n" + httpClientErrorException.getMessage(), httpClientErrorException);
        }
    }
}
