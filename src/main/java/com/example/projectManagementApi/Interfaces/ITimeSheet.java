package com.example.projectManagementApi.Interfaces;

import com.example.projectManagementApi.Models.TimeSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITimeSheet extends JpaRepository<TimeSheet,Integer> {
}
