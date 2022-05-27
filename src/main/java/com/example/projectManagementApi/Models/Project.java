package com.example.projectManagementApi.Models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="project_id")
    private Integer id;

    private String projectName;
    private String description;
    private Timestamp starDate;
    private Timestamp endDate;

    @OneToMany
    @JoinColumn(name="task_id")
    @JsonIgnoreProperties(value = {"project","users","comments"})
    private List<Task> Tasks;

    @ManyToMany(mappedBy = "projects")
    @JsonIgnoreProperties(value = {"projects","tasks","comments"})
    private List<User> users;

}
