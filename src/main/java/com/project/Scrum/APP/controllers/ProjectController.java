package com.project.Scrum.APP.controllers;

import com.project.Scrum.APP.models.Project;
import com.project.Scrum.APP.services.ProjectService;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping(path = "{id}")
    public Project updateProject(@RequestBody Project project, @PathVariable Integer id){
        return projectService.updateProject(project, id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteProject(@PathVariable Integer id) {
        projectService.deleteProject(id);
    }
}
