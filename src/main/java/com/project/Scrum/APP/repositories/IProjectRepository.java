package com.project.Scrum.APP.repositories;

import com.project.Scrum.APP.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProjectRepository extends JpaRepository<Project, Integer> {
}
