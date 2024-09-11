package com.project.Scrum.APP.controllers;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.project.Scrum.APP.models.Task;
import com.project.Scrum.APP.services.TaskService;

class TaskControllerTest {

    @Mock
    private TaskService taskService;

    @InjectMocks
    private TaskController taskController;

    private MockMvc mockController;

    private Task task;
    private List<Task> taskList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockController = MockMvcBuilders.standaloneSetup(taskController).build();

        task = new Task(1, "About Canva", "Task management system", true);
        //task.setId(1);
        //task.setName("About Canva");
        //task.setDescription("Task management system");
        //task.setStatus(true);

        taskList.add(task);
    }

    @Test
    void test_Create_Task() throws Exception {
        when(taskService.createTask(any(Task.class))).thenReturn(task);

        String taskJson =
                "{\"id\": 1,\n"
                + "\"name\": \"About Canva\",\n"
                + "\"description\": \"Task management system\",\n"
                + "\"status\": true}";

        mockController
                .perform(post("/api/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(taskJson))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\"id\": 1,\n"
                        + "\"name\": \"About Canva\",\n"
                        + "\"description\": \"Task management system\",\n"
                        + "\"status\": true}"));
    }

}






