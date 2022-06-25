package com.example.projectManagementApi.Custom;

import com.example.projectManagementApi.Models.Project;
import com.example.projectManagementApi.Models.User;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskRequest {
    public Integer id;
    public String title;
    public String description;
    public LocalDate startDate;
    public LocalDate endDate;
    public String priority;
    public String status;
    public Project projectId;
    public List<User> users = new ArrayList<>();
}
