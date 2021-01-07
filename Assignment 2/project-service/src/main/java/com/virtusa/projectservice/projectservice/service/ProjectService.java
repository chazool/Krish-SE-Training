package com.virtusa.projectservice.projectservice.service;


import com.virtusa.common.Project;

import java.util.List;

public interface ProjectService {
    String save(Project project);

    String update(int id, Project project);

    String delete(int id);

    Project findById(int id);

    List<Project> findAll();

    List<Project> findAll(String direction, String column);

    boolean existsById(int id);
}
