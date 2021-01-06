package com.virtusa.projectservice.projectservice.controller;

import com.virtusa.projectservice.projectservice.exception.CompulsoryFieldNullException;
import com.virtusa.projectservice.projectservice.model.Project;
import com.virtusa.projectservice.projectservice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/service/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @PostMapping
    public Project save(@RequestBody Project project) {
        String errorMessage = "";
        try {
            project = projectService.save(project);
        } catch (CompulsoryFieldNullException compulsoryFieldNullException) {
            errorMessage = compulsoryFieldNullException.getMessage();
        }

        System.out.println(errorMessage);


        return project;
    }

    @PutMapping(value = "/{id}")
    public Project update(@RequestBody Project project, @PathVariable int id) {
        return projectService.update(id, project);
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




}
