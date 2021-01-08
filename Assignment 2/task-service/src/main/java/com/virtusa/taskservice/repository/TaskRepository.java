package com.virtusa.taskservice.repository;

import com.virtusa.common.taskservice.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/***
 * @author chazool
 */
public interface TaskRepository extends JpaRepository<Task, Integer> {

    /***
     * The method for Find All Task By Project id
     * @param projectId
     * @return List<Task>
     */
    List<Task> findByProjectId(int projectId);

    @Modifying
    @Transactional
    @Query("update Task t set t.isActive=false where t.id = ?1")
    public int deactivateTask(int id);
}
