package com.example.projectManagementApi.Custom;

import com.example.projectManagementApi.Models.User;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ProjectRequest {
    public Integer id;
    public String projectName;
    public String description;
    public Timestamp startDate;
    public Timestamp endDate;
    public List<User> users = new ArrayList<>();
}
