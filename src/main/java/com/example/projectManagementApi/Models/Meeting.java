package com.example.projectManagementApi.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String meetingTitle;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Africa/Mogadishu")
    private Timestamp startingDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Africa/Mogadishu")
    private Timestamp endingDate;

    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(name = "meeting_users",
            joinColumns = @JoinColumn(name = "meeting_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
    @JsonIgnoreProperties(value = {"projects","tasks","meetings","notes"},allowSetters = true)
    private List<User> users = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonIgnoreProperties(value = {"users","tasks","meeting"})
    private Project project;


}
