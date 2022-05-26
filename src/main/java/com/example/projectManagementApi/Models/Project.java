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
public class Project {
    @Column(name="project_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String projectName;
    private String description;
    private Timestamp starDate;
    private Timestamp endDate;

    @ManyToOne
    @JoinColumn(name="task_id")
    private List<Task> Tasks;

    @ManyToMany(mappedBy = "projects")
    private List<User> users;


}
