package com.project.Scrum.APP.controllers;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Scrum.APP.models.Project;
import com.project.Scrum.APP.services.ProjectService;
@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "*")
public class ProjectController {
    ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public Project createProject(@RequestBody Project project){
        return projectService.createProject(project);
    }

    @PutMapping(path = "/{id}")
    public Project updateProject(@RequestBody Project project, @PathVariable Integer id){
        return projectService.updateProject(project, id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteProject(@PathVariable Integer id) {
        projectService.deleteProject(id);
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        try {
            List<Project> projects = projectService.getAllProjects();
            if (projects.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
            }
            return new ResponseEntity<>(projects, HttpStatus.OK);  
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); 
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable("id") int id) {
        try {
            if (id <= 0) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST); 
            }
            Project project = projectService.getProjectById(id);
            if (project == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
            }
            return new ResponseEntity<>(project, HttpStatus.OK); 
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}








