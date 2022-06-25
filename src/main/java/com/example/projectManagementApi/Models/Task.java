package com.example.projectManagementApi.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Integer id;
    private String title;
    private String description;
    private LocalDate startingDate;
    private LocalDate endingDate;
    private String status;
    private String priority;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @JsonIgnoreProperties(value = {"users","tasks"})
    private Project projects;

    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(name = "task_users",
    joinColumns = @JoinColumn(name = "task_id",referencedColumnName = "task_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
    @JsonIgnoreProperties(value = {"projects","tasks","comments","meetings","timeSheets","notes"})
    private List<User> users = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "task_id")
    @JsonIgnoreProperties(value = {"task"})
    private List<TaskComment> comments;

    @OneToMany
    @JoinColumn(name = "task_id")
    private List<TimeSheet> timeSheets;
}




