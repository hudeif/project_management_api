package com.example.projectManagementApi.Interfaces;

import com.example.projectManagementApi.Models.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMeeting extends JpaRepository<Meeting,Integer> {
}
