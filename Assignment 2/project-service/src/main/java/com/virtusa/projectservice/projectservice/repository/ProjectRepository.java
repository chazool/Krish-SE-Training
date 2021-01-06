package com.virtusa.projectservice.projectservice.repository;

import com.virtusa.projectservice.projectservice.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
