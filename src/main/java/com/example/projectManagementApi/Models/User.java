package com.example.projectManagementApi.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
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
    private String email;
    private String password;

    @ManyToOne
    @JoinColumn(name="role_id")
    @JsonIgnoreProperties(value = "users")
    private UserRole userRole;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "project_users",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id",referencedColumnName ="project_id" ))
    @JsonIgnoreProperties(value = {"users","tasks"})
    private List<Project> projects;

    @ManyToMany(mappedBy = "users")
    @JsonIgnoreProperties(value = {"users","comments","timeSheets"})
    private List<Task> tasks;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<TaskComment> comments;


    @ManyToMany(mappedBy = "users")
    @JsonIgnoreProperties(value = "users")
    private List<Meeting> meetings;

    @OneToMany
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"users"})
    private List<Note> notes;

    @OneToMany
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties(value = "tasks")
    private List<TimeSheet> timeSheets;

}







