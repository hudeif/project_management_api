package com.example.projectManagementApi.Interfaces;

import com.example.projectManagementApi.Models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INote extends JpaRepository<Note,Integer> {
}
