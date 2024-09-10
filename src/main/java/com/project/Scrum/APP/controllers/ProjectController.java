package com.project.Scrum.APP.controllers;

import com.project.Scrum.APP.models.Project;
import com.project.Scrum.APP.services.ProjectService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin(origins = "*")
public class ProjectController {

    private ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PutMapping(path = "{id}")
    public Project updateProject(Project project, Integer id){
        return projectService.updateProject(project, id);
    }
}
