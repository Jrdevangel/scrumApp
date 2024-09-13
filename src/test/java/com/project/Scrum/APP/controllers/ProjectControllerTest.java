package com.project.Scrum.APP.controllers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
    void test_GetAllProjects() throws Exception {
    
        Project secondProject = new Project(2, "SecondProject");
        projectList.add(secondProject);

    // Mockea el comportamiento del servicio para devolver la lista con dos proyectos
    when(projectService.getAllProjects()).thenReturn(projectList);

        mockController
                .perform(get("/api/projects"))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "[{\"id\": 1,\n"
                        + "\"name\": \"ScrumApp\"},\n"
                        + "{\"id\": 2,\n"
                        + "\"name\": \"SecondProject\"}]"))
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    void test_GetProjectById() throws Exception {
        when(projectService.getProjectById(anyInt())).thenReturn(project);

        mockController
                .perform(get("/api/projects/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{\"id\": 1,\n"
                        + "\"name\": \"ScrumApp\"}"));
    }

    @Test
    void test_GetProjectById_NotFound() throws Exception {
        when(projectService.getProjectById(anyInt())).thenReturn(null);

        mockController 
                .perform(get("/api/projects/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void test_GetAllProjects_EmptyList() throws Exception {
        when(projectService.getAllProjects()).thenReturn(new ArrayList<>());

        mockController
                .perform(get("/api/projects"))
                .andExpect(status().isNoContent());
    }
}

