package com.example.projectManagementApi.Interfaces;

import com.example.projectManagementApi.Models.TaskComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskComment extends JpaRepository<TaskComment,Integer> {
}
