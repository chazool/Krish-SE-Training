package com.virtusa.projectservice.projectservice.service;

import com.virtusa.projectservice.projectservice.exception.CompulsoryFieldNullException;
import com.virtusa.projectservice.projectservice.model.Project;
import com.virtusa.projectservice.projectservice.repository.ProjectRepository;
import org.hibernate.PropertyValueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public Project save(Project project) throws CompulsoryFieldNullException {
            project = projectRepository.save(project);
        return project;
    }

    @Override
    public Project update(int id, Project project) {
        project.setId(id);
        return projectRepository.save(project);
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
}
