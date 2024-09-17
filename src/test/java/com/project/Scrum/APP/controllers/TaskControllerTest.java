package com.project.Scrum.APP.controllers;

import com.project.Scrum.APP.models.Task;
import com.project.Scrum.APP.services.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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

        task = new Task();
        task.setId(1);
        task.setName("Task");
        task.setDescription("Task management system");
        task.setStatus(true);

        Task secondTask = new Task();
        secondTask.setId(2);
        secondTask.setName("Second Task");

        taskList.add(task);
        taskList.add(secondTask);
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
                        + "\"name\": \"Task\",\n"
                        + "\"description\": \"Task management system\",\n"
                        + "\"status\": true}"));
    }

    @Test
    void deleteTask() throws Exception {
        doNothing().when(taskService).deleteTask(1);

        mockController.perform(MockMvcRequestBuilders.delete("/api/tasks/1")).andExpect(status().isOk());
    }
    @Test
    void test_update_task() throws Exception {
        when(taskService.updateTask(any(Task.class), any(Integer.class))).thenReturn(task);

        String updateTaskJson =
                "{\"id\": 1,\n"
                        + "\"name\": \"About Canva\",\n"
                        + "\"description\": \"Task management system\",\n"
                        + "\"status\": true}";

        mockController
                .perform(put("/api/tasks/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updateTaskJson))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\"id\": 1,\n"
                                + "\"name\": \"About Canva\",\n"
                                + "\"description\": \"Task management system\",\n"
                                + "\"status\": true}"));

        verify(taskService).updateTask(any(Task.class), any(Integer.class));
    }
     @Test
    void test_GetAllTasks() throws Exception {
        when(taskService.getAllTask()).thenReturn(taskList);

        mockController
                .perform(get("/api/tasks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(content().json(
                        "[{\"id\": 1, \"name\": \"Task\"}, {\"id\": 2, \"name\": \"Second Task\"}]"));
    }

    
    @Test
    void test_GetTasksById() throws Exception {
        when(taskService.getTaskById(anyInt())).thenReturn(task);

        mockController
                .perform(get("/api/tasks/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\"id\": 1,\n"
                        + "\"name\": \"Task\"}"));
    }

    @Test
    void test_GetTasksById_NotFound() throws Exception {
        when(taskService.getTaskById(anyInt())).thenReturn(null);

        mockController 
                .perform(get("/api/tasks/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void test_GetAllTasks_EmptyList() throws Exception {
        when(taskService.getAllTask()).thenReturn(new ArrayList<>());

        mockController
                .perform(get("/api/tasks"))
                .andExpect(status().isNoContent());
    }
}






