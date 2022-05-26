package com.example.projectManagementApi.Interfaces;

import com.example.projectManagementApi.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITask extends JpaRepository<Task,Integer> {
}
