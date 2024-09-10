package com.project.Scrum.APP.controllers;

import com.project.Scrum.APP.services.TaskService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {
    private TaskService taskService;


    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
}
