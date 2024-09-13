package com.project.Scrum.APP.services;

import com.project.Scrum.APP.models.Task;
import com.project.Scrum.APP.repositories.ITaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    ITaskRepository iTaskRepository;


    public TaskService(ITaskRepository iTaskRepository) {
        this.iTaskRepository = iTaskRepository;
    }

    public Task createTask(Task newTask) {
        return iTaskRepository.save(newTask);
    }

    public void deleteTask(Integer id) {
        iTaskRepository.deleteById(id);
    }
}
