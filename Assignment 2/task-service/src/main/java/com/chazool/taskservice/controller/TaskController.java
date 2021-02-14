package com.chazool.taskservice.controller;

import com.chazool.common.responsehandle.Response;
import com.chazool.common.taskservice.Task;
import com.chazool.taskservice.exception.InvalidProjectException;
import com.chazool.taskservice.exception.ProjectServiceException;
import com.chazool.taskservice.exception.TaskIdNullPointerException;
import com.chazool.taskservice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/***
 * @author chazool
 */
@RestController
@RequestMapping("/service/task")
public class TaskController {

    @Autowired
    private TaskService taskService;
    @Autowired
    private RestTemplate restTemplate;

    /***
     * The method for save Task ,
     *  beofore Check and Validate Project Id
     * @param task
     * @return ResponseEntity<Response>
     * @throws TaskIdNullPointerException
     * @throws InvalidProjectException
     * @throws ProjectServiceException
     */
    @PostMapping
    public ResponseEntity<Response> save(@RequestBody Task task) throws TaskIdNullPointerException, InvalidProjectException, ProjectServiceException {
        return new ResponseEntity<Response>(new Response().success(taskService.save(task)), HttpStatus.OK);
    }

    /***
     * The method for update (Edit) task , before check project
     * @param task
     * @param id
     * @return ResponseEntity<Response>
     * @throws TaskIdNullPointerException
     * @throws InvalidProjectException
     * @throws ProjectServiceException
     */
    @PutMapping("/{id}")
    public ResponseEntity<Response> update(@RequestBody Task task, @PathVariable int id) throws TaskIdNullPointerException, InvalidProjectException, ProjectServiceException {
        return new ResponseEntity<Response>(new Response().success(taskService.update(id, task)), HttpStatus.OK);

    }

    /***
     * The method for delete task
     * @param id
     * @return ResponseEntity<Response>
     * @throws TaskIdNullPointerException
     * @throws HttpClientErrorException
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable int id) throws TaskIdNullPointerException, HttpClientErrorException {
        return new ResponseEntity<Response>(new Response().success(taskService.delete(id)), HttpStatus.OK);

    }

    /***
     *  The method for fetch Task by Task Id
     * @param id
     * @return ResponseEntity<Response> - single Task
     */
    @GetMapping("/{id}")
    public Task getTask(@PathVariable int id) {
        return taskService.findById(id);
    }

    /***
     * The method fetch all Tasks
     * @return List<Task>
     */
    @GetMapping
    public List<Task> getTask() {
        return taskService.findAll();
    }

    /**
     * The method for fetch Task by project id
     *
     * @param projectId
     * @return ResponseEntity<Response> - multiple Project
     * @throws InvalidProjectException
     * @throws HttpClientErrorException
     */
    @GetMapping("/project/{projectId}")
    public ResponseEntity<Response> getTaskByProjectId(@PathVariable int projectId) throws InvalidProjectException, HttpClientErrorException {
        return new ResponseEntity<Response>(new Response().success(taskService.findByProjectId(projectId)), HttpStatus.OK);
    }

}
