package com.project.Scrum.APP.controllers;

import com.project.Scrum.APP.models.Task;
import com.project.Scrum.APP.services.TaskService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }


    @PutMapping(path = "{id}")
    public Task updateTask(@RequestBody Task task, @PathVariable Integer id){
        return taskService.updateTask(task, id);
    }
}
