package com.project.Scrum.APP.services;

import com.project.Scrum.APP.repositories.ITaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private ITaskRepository iTaskRepository;


    public TaskService(ITaskRepository iTaskRepository) {
        this.iTaskRepository = iTaskRepository;
    }
}
