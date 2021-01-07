package com.virtusa.projectservice.projectservice.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.virtusa.common.Project;
import com.virtusa.projectservice.projectservice.exception.IllegalSortDirectionException;
import com.virtusa.projectservice.projectservice.exception.InvalidColumnException;
import com.virtusa.projectservice.projectservice.exception.ProjectIdNullPointException;
import com.virtusa.projectservice.projectservice.service.ProjectService;
import org.json.simple.JSONObject;
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

    @GetMapping("/{column}/{direction}")
    public JSONObject getProjects(@PathVariable String column, @PathVariable String direction) {
        List<Project> projects = null;
        String message = null;
        try {
            projects = projectService.findAll(direction, column);
        } catch (IllegalSortDirectionException illegalSortDirectionException) {
            message = illegalSortDirectionException.getMessage();
        } catch (InvalidColumnException invalidColumnException) {
            message = invalidColumnException.getMessage();
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("projects", projects);
        jsonObject.put("message", message);

        return jsonObject;
    }

    @GetMapping
    public List<Project> getProjects() {
        return projectService.findAll();
    }

    @GetMapping(value = "/isAvailable/{id}")
    public Boolean isAvailable(@PathVariable int id) {
        return projectService.existsById(id);
    }

}
