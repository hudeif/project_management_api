package com.example.projectManagementApi.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TimeSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp startTime;
    private Timestamp endTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties(value = {"meetings","comments","tasks","projects","userRole","notes","timeSheets"})
    private User users;

    @ManyToOne
    @JoinColumn(name = "task_id")
    @JsonIgnoreProperties(value = {"projects","comments","users","timeSheets"})
    private Task tasks;
}
