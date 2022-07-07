package com.example.projectManagementApi.Interfaces;

import com.example.projectManagementApi.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUser extends JpaRepository<User,Integer> {

    @Query(value = "SELECT * from user u where u.email=?1 and u.password=?2 ",nativeQuery = true)
    User checkUser(String email,String password);
}
