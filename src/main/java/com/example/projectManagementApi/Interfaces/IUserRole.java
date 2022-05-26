package com.example.projectManagementApi.Interfaces;

import com.example.projectManagementApi.Models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRole extends JpaRepository<UserRole,Integer> {
}
