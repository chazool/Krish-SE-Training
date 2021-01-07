package com.virtusa.projectservice.projectservice.service;

import com.virtusa.common.Project;
import com.virtusa.projectservice.projectservice.exception.IllegalSortDirectionException;
import com.virtusa.projectservice.projectservice.exception.InvalidColumnException;
import com.virtusa.projectservice.projectservice.exception.ProjectIdNullPointException;
import com.virtusa.projectservice.projectservice.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public String save(Project project) {
        //Create Active Task
        project.setActive(true);

        if (Optional.of(projectRepository.save(project)).isPresent()) {
            return "Id: " + project.getId() + " Save Successful";
        } else {
            return "Save Unsuccessful";
        }

    }

    @Override
    public String update(int id, Project project) throws ProjectIdNullPointException {
        if (id <= 0) {
            throw new ProjectIdNullPointException("Invalid Project Id");
        } else {
            project.setId(id);
            if (Optional.of(projectRepository.save(project)).isPresent()) {
                return "Update Successful";
            } else {
                return "Update Unsuccessful";
            }
        }
    }

    @Override
    public String delete(int id) throws ProjectIdNullPointException {
        if (id <= 0) {
            throw new ProjectIdNullPointException("Invalid Project Id");
        } else {
            Project project = new Project();
            project.setId(id);
            project.setActive(false);

            if (Optional.of(projectRepository.save(project)).isPresent()) {
                return "Delete Successful";
            } else {
                return "Delete Unsuccessful";
            }
        }

    }

    @Override
    public Project findById(int id) {
        Optional<Project> project = projectRepository.findById(id);
        if (project.isPresent())
            return project.get();
        else
            return null;
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    /*
    direction - [ASC | DESC],
    column - Sorted Column Name
     */
    @Override
    public List<Project> findAll(String direction, String column) throws IllegalSortDirectionException, InvalidColumnException {
        //valid - Direction
        Sort.Direction shortDirection;
        switch (direction.toUpperCase()) {
            case "ASC":
                shortDirection = Sort.Direction.ASC;
                break;
            case "DESC":
                shortDirection = Sort.Direction.DESC;
                break;
            default:
                shortDirection = null;
                throw new IllegalSortDirectionException(direction + " is Invalid Sort Direction , Valid direction - [ASC | DESC] ");
        }
        // valid Column
        if (Optional.of(column).isPresent())
            return projectRepository.findAll(Sort.by(shortDirection, column));
        else
            throw new InvalidColumnException(column + "is Invalid Column");
    }

    @Override
    public boolean existsById(int id) {
        return projectRepository.existsById(id);
    }
}
