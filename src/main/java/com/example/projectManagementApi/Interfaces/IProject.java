package com.example.projectManagementApi.Interfaces;

import com.example.projectManagementApi.Models.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProject extends JpaRepository<Project,Integer> {
}
