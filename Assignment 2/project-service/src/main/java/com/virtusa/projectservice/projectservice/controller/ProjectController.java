package com.virtusa.projectservice.projectservice.controller;

import com.virtusa.common.Project;
import com.virtusa.projectservice.projectservice.exception.CompulsoryFieldNullException;
import com.virtusa.projectservice.projectservice.exception.ProjectIdNullPointException;
import com.virtusa.projectservice.projectservice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @PostMapping
    public String save(@RequestBody Project project) {
        return projectService.save(project);
    }

    @PutMapping(value = "/{id}")
    public String update(@RequestBody Project project, @PathVariable int id) {
        try {
            return projectService.update(id, project);
        } catch (ProjectIdNullPointException projectIdNullPointException) {
            return projectIdNullPointException.getMessage();
        }
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable int id) {
        try {
            return projectService.delete(id);
        } catch (ProjectIdNullPointException projectIdNullPointException) {
            return projectIdNullPointException.getMessage();
        }
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<Project> getProject(@PathVariable int id) {
        Project project = projectService.findById(id);
        if (project == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().body(project);
    }


    @GetMapping
    public List<Project> getProjects() {
        return projectService.findAll();
    }

    @GetMapping(value = "/isAvailable/{id}")
    public Boolean isAvailable(@PathVariable int id) {
        if (projectService.findById(id) == null)
            return false;
        else
            return true;
    }

}
