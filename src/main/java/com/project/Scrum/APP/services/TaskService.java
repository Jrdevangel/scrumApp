package com.project.Scrum.APP.services;

import org.springframework.stereotype.Service;

import com.project.Scrum.APP.models.Task;
import com.project.Scrum.APP.repositories.ITaskRepository;

@Service
public class TaskService {

    ITaskRepository iTaskRepository;


    public TaskService(ITaskRepository iTaskRepository) {
        this.iTaskRepository = iTaskRepository;
    }


    public Task createTask(Task newTask) {
        return iTaskRepository.save(newTask);
    }



    
    public Task updateTask(Task task, Integer id){
        task.setId(id);
        return iTaskRepository.save(task);
    }
}
