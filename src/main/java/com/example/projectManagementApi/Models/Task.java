package com.example.projectManagementApi.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
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
    private Timestamp startinDate;
    private Timestamp endingDate;
    private String status;
    private String priority;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(name = "task_users",
    joinColumns = @JoinColumn(name = "task_id",referencedColumnName = "task_id"),
    inverseJoinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"))
    private List<User> users;
}
