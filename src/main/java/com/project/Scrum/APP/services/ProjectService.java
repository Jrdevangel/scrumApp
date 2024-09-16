package com.project.Scrum.APP.services;

import com.project.Scrum.APP.models.Project;
import com.project.Scrum.APP.repositories.IProjectRepository;
import org.springframework.stereotype.Service;

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

    public void deleteProject(Integer id) {
        iProjectRepository.deleteById(id);
    }
}
