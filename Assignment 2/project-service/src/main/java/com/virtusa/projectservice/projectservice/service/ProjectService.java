package com.virtusa.projectservice.projectservice.service;

import com.virtusa.common.projectservice.Project;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Chazool
 */
public interface ProjectService {

    /***
     * The method for  save project
     *
     * @param project
     * @return String
     */
    Project save(Project project);

    /***
     * The method for to Edit or Change Project
     * @param id
     * @param project
     * @return Project
     */
    Project update(int id, Project project);

    /**
     * The method for Delete Project
     *
     * @param id
     * @return
     */
    Project delete(int id);

    /***
     * The method for  fetch Project using by Project Id
     * @param id
     * @return Project
     */
    Project findById(int id);

    /***
     * The method for fetch projects using by IsActive Status
     * @param isActive
     * @return List<Project> -  project list
     */
    List<Project> findByIsActive(boolean isActive);

    /***
     * The method used to fetch the Projects using Budget
     * @param option
     * @param budget
     * @return List<Project>
     */
    List<Project> getProjectsByBudgetComparison(String option, BigDecimal budget);

    /***
     * The method for fetch the All Projects
     * @return List<Project>
     */
    List<Project> findAll();

    /**
     * The method for fetch with Sort Project using by column name
     *
     * @param direction - sorting Type
     * @param column
     * @return List<Project>
     */
    List<Project> findAll(String direction, String column);

    /**
     * The method for check the Existing project , it is available or Not
     *
     * @param id
     * @return boolean - available = true | not = false
     */
    boolean existsById(int id);
}
