package com.example.projectManagementApi.Interfaces;

import com.example.projectManagementApi.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUser extends JpaRepository<User,Integer> {
}
