package com.example.vacationmanager.dao;

import com.example.vacationmanager.tables.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, String> {


}