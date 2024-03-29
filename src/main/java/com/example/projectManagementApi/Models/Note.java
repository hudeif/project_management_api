package com.example.projectManagementApi.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String body;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss",timezone = "Africa/Mogadishu")
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties(value = {"meetings","comments","tasks","projects","userRole","notes","timeSheets"})
    private User users;

}
