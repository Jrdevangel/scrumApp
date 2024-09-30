package com.project.Scrum.APP.services;

import com.project.Scrum.APP.models.Task;
import com.project.Scrum.APP.repositories.ITaskRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class TaskServiceTest {

    @Mock
    private ITaskRepository iTaskRepository;

    @InjectMocks
    private TaskService taskService;

    private Task task;
    private List<Task> taskList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        task = new Task();
        task.setId(1);
        task.setName("Testing with Postman");
        task.setDescription("Verification of requests");
        task.setStatus(true);

        taskList.add(task);
    }

    @Test
    void test_Create_Task() {
        when(iTaskRepository.save(any(Task.class))).thenReturn(task);

        Task task1 = taskService.createTask(task);

        assertNotNull(task1);
        assertEquals(1, task1.getId());
        assertEquals("Testing with Postman", task1.getName());
        assertEquals("Verification of requests", task1.getDescription());

        verify(iTaskRepository, times(1)).save(any(Task.class));
    }

    @Test
    void deleteTask() {
        when(iTaskRepository.findById(2)).thenReturn(Optional.of(task));

        taskService.deleteTask(2);

        verify(iTaskRepository, times(1)).deleteById(2);
    }

    @Test
    void test_update_task() {
        when(iTaskRepository.save(any(Task.class))).thenReturn(task);

        Task result = taskService.updateTask(task, 2);

        assertNotNull(result);
        assertEquals(2, result.getId());
        assertEquals("Testing with Postman", result.getName());
        assertEquals("Verification of requests", result.getDescription());

        verify(iTaskRepository, times(1)).save(any(Task.class));
    }
}