package com.example.projectManagementApi.Models;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="project_id")
    private Integer id;

    private String projectName;
    private String description;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd",timezone = "Africa/Mogadishu")
    private Timestamp startDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd",timezone = "Africa/Mogadishu")
    private Timestamp endDate;

    @OneToMany
    @JoinColumn(name="project_id")
    @JsonIgnoreProperties(value = {"project"})
    private List<Task> Tasks ;

    @OneToMany
    @JoinColumn(name="project_id")
    @JsonIgnoreProperties(value = {"project"},allowSetters = true)
    private List<Meeting> Meeting ;

    @ManyToMany()
    @JoinTable(name = "project_users",
            joinColumns = @JoinColumn(name = "project_id",referencedColumnName = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id",referencedColumnName ="user_id" ))
    @JsonIgnoreProperties(value = {"projects","tasks","comments","timeSheets","notes"})
    private List<User> users = new ArrayList<>();

}
