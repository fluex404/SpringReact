package com.fluex404.reactspring.repository;

import com.fluex404.reactspring.domain.ProjectTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjectTaskDao extends JpaRepository<ProjectTask, UUID> {
}
