package com.project.Scrum.APP.repositories;

import com.project.Scrum.APP.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository<Task, Integer> {
}
