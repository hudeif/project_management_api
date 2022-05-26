package com.example.projectManagementApi.Models;

import javax.persistence.ManyToMany;
import java.util.List;

public class User {
    @ManyToMany(mappedBy = "users")
    private List<Task> tasks;

    // comments
}
