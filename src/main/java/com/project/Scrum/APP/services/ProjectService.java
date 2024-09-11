package com.project.Scrum.APP.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.Scrum.APP.models.Project;
import com.project.Scrum.APP.repositories.IProjectRepository;
@Service
public class ProjectService {

    IProjectRepository iProjectRepository;


    public ProjectService(IProjectRepository iProjectRepository) {
        this.iProjectRepository = iProjectRepository;
    }

    public Project createProject(Project newProject) {
        return iProjectRepository.save(newProject);
    }

    public Project updateProject(Project project, Integer id){
        project.setId(id);
        return iProjectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return iProjectRepository.findAll();
    }

    public Project getProjectById(int id) {
        Optional<Project> project = iProjectRepository.findById(id);
        return project.orElse(null);  
    }
}
