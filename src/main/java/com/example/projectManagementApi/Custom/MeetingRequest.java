package com.example.projectManagementApi.Custom;

import com.example.projectManagementApi.Models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MeetingRequest {

    public Integer id ;
    public String meetingTitle;
    public LocalDate startingDate;
    public LocalDate endingDate;
    public List<User> users = new ArrayList<>();

}
