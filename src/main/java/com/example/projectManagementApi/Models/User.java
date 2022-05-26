package com.example.projectManagementApi.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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
    private UserRole userRole;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "project_users",
            joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id",referencedColumnName ="project_id" ))
    private List<Project> projects;

    @ManyToMany(mappedBy = "users")
    private List<Task> tasks;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<TaskComment> comments;

}







