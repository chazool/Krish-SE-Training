package com.virtusa.projectservice.projectservice.repository;


import com.virtusa.common.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
}
