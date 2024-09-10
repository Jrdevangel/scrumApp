package com.project.Scrum.APP.services;

import com.project.Scrum.APP.repositories.IProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private IProjectRepository iProjectRepository;


    public ProjectService(IProjectRepository iProjectRepository) {
        this.iProjectRepository = iProjectRepository;
    }
}
