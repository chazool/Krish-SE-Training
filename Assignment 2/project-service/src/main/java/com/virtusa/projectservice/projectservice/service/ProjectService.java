package com.virtusa.projectservice.projectservice.service;

import com.virtusa.projectservice.projectservice.model.Project;

import java.util.List;

public interface ProjectService {
    Project save(Project project);
    Project update(int id,Project project );
    Project findById(int id);
    List<Project> findAll();
}
