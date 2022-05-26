package com.example.projectManagementApi.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String body;
    private Timestamp date;

    @OneToMany
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany
    @JoinColumn(name = "project_id")
    private Project project;

}
