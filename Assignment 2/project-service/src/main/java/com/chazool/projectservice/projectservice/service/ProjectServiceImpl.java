package com.chazool.projectservice.projectservice.service;

import com.chazool.common.projectservice.Project;
import com.chazool.projectservice.projectservice.exception.IllegalSortDirectionException;
import com.chazool.projectservice.projectservice.exception.InvalidColumnException;
import com.chazool.projectservice.projectservice.exception.ProjectIdNullPointException;
import com.chazool.projectservice.projectservice.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/***
 * @author Chazool
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    /***
     * Save project before SetActive = true
     * @param project
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Project save(Project project) throws IllegalArgumentException {
        //Create Active Task
        project.setActive(true);
        return projectRepository.save(project);
    }

    /**
     * {@inheritDoc}
     *
     * @param id
     * @param project
     * @return Project
     * @throws ProjectIdNullPointException
     * @throws IllegalArgumentException
     */
    @Override
    public Project update(int id, Project project) throws ProjectIdNullPointException, IllegalArgumentException {
        if (id <= 0) {
            throw new ProjectIdNullPointException("Invalid Project Id");
        } else {
            project.setId(id);
            return projectRepository.save(project);
        }
    }

    /***
     * {@inheritDoc}
     * @param id
     * @return Project
     * @throws ProjectIdNullPointException
     * @throws IllegalArgumentException
     */
    @Override
    public Project delete(int id) throws ProjectIdNullPointException, IllegalArgumentException {
        if (id <= 0) {
            throw new ProjectIdNullPointException("Invalid Project Id");
        } else {
            return projectRepository.deactivateIsActive(id) == 1 ? projectRepository.findById(id).get() : null;

        }

    }

    /***
     * {@inheritDoc}
     * @param id
     * @return Project
     */
    @Override
    public Project findById(int id) throws IllegalArgumentException {
        Optional<Project> project = projectRepository.findById(id);
        if (project.isPresent())
            return project.get();
        else
            return null;
    }

    /**
     * {@inheritDoc}
     *
     * @param isActive
     * @return List<Project>
     */
    @Override
    public List<Project> findByIsActive(boolean isActive) {
        return projectRepository.findByIsActive(isActive);
    }

    /***
     * {@inheritDoc}
     * @param option - [
     *        Less Than = LS
     *         Greater Than =  GT
     *         Less Than or Equal To =  LTEQ
     *         Greater Than or Equal =  GTEQ
     *         Equal = EQ
     *         Not Equal =  NOT
     *     ]
     * @param budget
     * @return List<Project>
     */
    @Override
    public List<Project> getProjectsByBudgetComparison(String option, BigDecimal budget) {
        List<Project> projects = null;
        option = option.trim().toUpperCase();
        switch (option) {
            case "GTEQ":
                projects = projectRepository.findByBudgetGreaterThanEqual(budget);
                break;
            case "LTEQ":
                projects = projectRepository.findByBudgetLessThanEqual(budget);
                break;
            case "GT":
                projects = projectRepository.findByBudgetGreaterThan(budget);
                break;
            case "LS":
                projects = projectRepository.findByBudgetLessThan(budget);
                break;
            case "NOT":
                projects = projectRepository.findByBudgetNot(budget);
                break;
            default:
                if (option == null || option == "") {
                    projects = projectRepository.findByBudget(budget);
                }
                break;

        }
        return projects;

    }

    /**
     * {@inheritDoc}
     *
     * @return List<Project>
     */
    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    /***
     * [@inheritDoc]
     * @param direction - sorting Type
     * @param column
     * @return List<Project>
     * @throws IllegalSortDirectionException
     * @throws InvalidColumnException
     */
    @Override
    public List<Project> findAll(String direction, String column) throws IllegalSortDirectionException, InvalidColumnException {
        //valid - Direction
        Sort.Direction shortDirection;
        switch (direction.trim().toUpperCase()) {
            case "ASC":
                shortDirection = Sort.Direction.ASC;
                break;
            case "DESC":
                shortDirection = Sort.Direction.DESC;
                break;
            default:
                throw new IllegalSortDirectionException(direction + " is Invalid Sort Direction , Valid direction - [ASC | DESC] ");
        }
        // valid Column
        if (Optional.of(column).isPresent())
            return projectRepository.findAll(Sort.by(shortDirection, column));
        else
            throw new InvalidColumnException(column + "is Invalid Column");
    }

    /***
     * {@inheritDoc}
     * @param id
     * @return boolean
     */
    @Override
    public boolean existsById(int id) {
        return projectRepository.existsById(id);
    }
}
