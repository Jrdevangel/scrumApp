package com.project.Scrum.APP.services;

import com.project.Scrum.APP.models.Task;
import com.project.Scrum.APP.repositories.ITaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

@Service
public class TaskService {

    private ITaskRepository iTaskRepository;


    public TaskService(ITaskRepository iTaskRepository) {
        this.iTaskRepository = iTaskRepository;
    }

    public Task updateTask(Task task, Integer id){
        task.setId(id);
        return iTaskRepository.save(task);
    }
}
