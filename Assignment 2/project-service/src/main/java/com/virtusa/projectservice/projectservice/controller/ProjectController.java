package com.virtusa.projectservice.projectservice.controller;

import com.virtusa.common.projectservice.Project;
import com.virtusa.common.responsehandle.Response;
import com.virtusa.projectservice.projectservice.exception.IllegalSortDirectionException;
import com.virtusa.projectservice.projectservice.exception.InvalidColumnException;
import com.virtusa.projectservice.projectservice.exception.ProjectIdNullPointException;
import com.virtusa.projectservice.projectservice.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/***
 * @author chazool
 */
@RestController
@RequestMapping("/service/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    /***
     * The method is save project
     * Request Mapping - Post
     * @param project
     * @return ResponseEntity<Response>
     */
    @PostMapping
    public ResponseEntity<Response> save(@RequestBody Project project) throws IllegalArgumentException {
        return new ResponseEntity<Response>(new Response().success(projectService.save(project)), HttpStatus.OK);
    }

    /***
     * That method is Edit Project
     * @param project
     * @param id
     * @return
     * @throws ProjectIdNullPointException
     * @throws IllegalArgumentException
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<Response> update(@RequestBody Project project, @PathVariable int id)
            throws ProjectIdNullPointException, IllegalArgumentException {
        return new ResponseEntity<Response>(new Response().success(projectService.update(id, project)), HttpStatus.OK);
    }

    /***
     * the methor use to delete or Inactive Project
     * Active - true | Inactive - false
     * @param id
     * @return ResponseEntity<Response>
     * @throws ProjectIdNullPointException
     * @throws IllegalArgumentException
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Response> delete(@PathVariable int id)
            throws ProjectIdNullPointException, IllegalArgumentException {
        Project project = projectService.delete(id);
        if (project == null) {
            return new ResponseEntity<Response>(new Response().fail(null), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Response>(new Response().success(project), HttpStatus.OK);
        }

    }

    /***
     * The method is fetch project by ID
     * @param id
     * @return ResponseEntity<Project>
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Project> getProject(@PathVariable int id) throws IllegalArgumentException {
        Project project = projectService.findById(id);
        if (project == null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().body(project);
    }

    /***
     * The method use fetch Project
     * @param column
     * @param direction - [ASC | DESC]
     * @return ResponseEntity<Project>
     * @throws IllegalSortDirectionException
     * @throws InvalidColumnException
     */
    @GetMapping("/{column}/{direction}")
    public List<Project> getProjects(@PathVariable String column, @PathVariable String direction)
            throws IllegalSortDirectionException, InvalidColumnException {
        return projectService.findAll(direction, column);
    }

    /***
     *  The method fetch all projects
     * @return List<Project>
     */
    @GetMapping
    public List<Project> getProjects() {
        return projectService.findAll();
    }

    @GetMapping(value = "/IsActive/{status}")
    public List<Project> getProjectsByIsActive(@PathVariable boolean status) {
        return projectService.findByIsActive(status);
    }


    /***
     * The method is fetch projects by budget Comparison
     * @param option -[
     *         Less Than = LS
     *         Greater Than =  GT
     *         Less Than or Equal To =  LTEQ
     *         Greater Than or Equal =  GTEQ
     *         Equal = EQ
     *         Not Equal =  NOT
     *         ]
     * @param budget
     * @return List<Project>
     */
    @GetMapping(value = "/budget/{option}/{budget}")
    public List<Project> getProjectsByComparisonBudget(@PathVariable String option, @PathVariable BigDecimal budget) {
        return projectService.getProjectsByBudgetComparison(option, budget);
    }

    /***
     * The method is identify  projectId is Existing
     * @param id
     * @return Boolean
     */
    @GetMapping(value = "/isAvailable/{id}")
    public Boolean isAvailable(@PathVariable int id) {
        return projectService.existsById(id);
    }

}
