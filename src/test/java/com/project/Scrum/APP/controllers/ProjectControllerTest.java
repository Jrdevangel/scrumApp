package com.project.Scrum.APP.controllers;

import com.project.Scrum.APP.models.Project;
import com.project.Scrum.APP.services.ProjectService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ProjectControllerTest {

    @Mock
    private ProjectService projectService;

    @InjectMocks
    private ProjectController projectController;

    private MockMvc mockController;

    private Project project;
    private List<Project> projectList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockController = MockMvcBuilders.standaloneSetup(projectController).build();

        project = new Project();
        project.setId(1);
        project.setName("ScrumApp");

        projectList.add(project);
    }

    @Test
    void test_Create_Project() throws Exception {
        when(projectService.createProject(any(Project.class))).thenReturn(project);

        String projectJson =
                "{\"id\": 1,\n"
                + "\"name\": \"ScrumApp\"}";

        mockController
                .perform(post("/api/projects")
                .contentType(MediaType.APPLICATION_JSON)
                .content(projectJson))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\"id\": 1,\n"
                        + "\"name\": ScrumApp}"));

    }

    @Test
    void test_update_project() throws Exception {
        when(projectService.updateProject(any(Project.class), any(Integer.class))).thenReturn(project);

        String updateProjectJson =
                "{\"id\": 1,\n"
                        + "\"name\": \"ScrumApp\"}";

        mockController
                .perform(put("/api/projects/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(updateProjectJson))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\"id\": 1,\n"
                                + "\"name\": ScrumApp}"));

        verify(projectService).updateProject(any(Project.class), any(Integer.class));
    }

    @Test
    void deleteProject() throws Exception {
        doNothing().when(projectService).deleteProject(1);

        mockController.perform(MockMvcRequestBuilders.delete("/api/projects/1")).andExpect(status().isOk());
    }
}