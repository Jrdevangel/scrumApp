package com.project.Scrum.APP.services;

import com.project.Scrum.APP.models.Project;
import com.project.Scrum.APP.repositories.IProjectRepository;
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

class ProjectServiceTest {

    @Mock
    private IProjectRepository iProjectRepository;

    @InjectMocks
    private ProjectService projectService;

    private Project project;
    private List<Project> projectList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        project = new Project();
        project.setId(1);
        project.setName("ScrumApp");

        projectList.add(project);
    }

    @Test
    void test_Create_Project() {
        when(iProjectRepository.save(any(Project.class))).thenReturn(project);

        Project result = projectService.createProject(project);

        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("ScrumApp", result.getName());

        verify(iProjectRepository, times(1)).save(any(Project.class));
    }

    @Test
    void deleteProject() {
        when(iProjectRepository.findById(2)).thenReturn(Optional.of(project));

        projectService.deleteProject(2);

        verify(iProjectRepository, times(1)).deleteById(2);
    }
}