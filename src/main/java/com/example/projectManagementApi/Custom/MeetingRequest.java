package com.example.projectManagementApi.Custom;

import com.example.projectManagementApi.Models.Project;
import com.example.projectManagementApi.Models.User;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MeetingRequest {

    public Integer id ;
    public String meetingTitle;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Africa/Mogadishu")
    public Timestamp startingDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Africa/Mogadishu")
    public Timestamp endingDate;
    public String status;
    public String agenda;
    public String discussionResult;
    public Project project;
    public List<User> users = new ArrayList<>();

}
