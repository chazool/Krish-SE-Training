package com.virtusa.taskservice.service;

import com.virtusa.common.taskservice.Task;
import com.virtusa.taskservice.exception.TaskIdNullPointerException;

import java.util.List;

/***
 * @author chazool
 */
public interface TaskService {

    /***
     *  The method for save Task
     * @param task
     * @return
     */
    Task save(Task task);

    /***
     * The method for Update task by Task ID
     * @param id
     * @param task
     * @return Task
     * @throws TaskIdNullPointerException
     */
    Task update(int id, Task task) throws TaskIdNullPointerException;

    /**
     * The method for fetch Task by Task ID
     * @param id
     * @return Task
     */
    Task findById(int id);

    /**
     * The method for fetch All Tasks
     * @return List<Task>
     */
    List<Task> findAll();

    /***
     * The method for fetch All Task in Project Id
     * @param projectId
     * @return List<Task>
     */
    List<Task> findByProjectId(int projectId);

    /***
     * The method for Delete task by Task Id
     * @param id
     * @return Task
     */
    Task delete(int id);


}
