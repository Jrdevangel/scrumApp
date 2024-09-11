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

import com.project.Scrum.APP.models.Project;
import com.project.Scrum.APP.services.ProjectService;

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
}

