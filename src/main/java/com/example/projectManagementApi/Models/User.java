package com.example.projectManagementApi.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;
    private String firstName;
    private String lastName;
    private String email = "admin@gmail.com";
    private String password = "1234";

    @ManyToOne
    @JoinColumn(name="role_id")
    @JsonIgnoreProperties(value = "users")
    private UserRole userRole;

    @ManyToMany(mappedBy = "users")
    @JsonIgnoreProperties(value = {"users","tasks"})
    private List<Project> projects = new ArrayList<>();

    @ManyToMany(mappedBy = "users")
    @JsonIgnoreProperties(value = {"users","comments","timeSheets"})
    private List<Task> tasks = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<TaskComment> comments;


    @ManyToMany(mappedBy = "users")
    @JsonIgnoreProperties(value = "users",allowSetters = true)
    private List<Meeting> meetings = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"users"})
    private List<Note> notes;

    @OneToMany
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties(value = "tasks")
    private List<TimeSheet> timeSheets;

}







