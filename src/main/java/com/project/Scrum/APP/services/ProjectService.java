package com.project.Scrum.APP.services;

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

}
