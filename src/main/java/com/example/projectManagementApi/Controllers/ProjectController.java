package com.example.projectManagementApi.Controllers;

import com.example.projectManagementApi.Interfaces.IProject;
import com.example.projectManagementApi.Models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("project")
@CrossOrigin(maxAge = 3600)
public class ProjectController {
    @Autowired
    IProject iProject;

    @GetMapping("/list")
    public List<Project> getAll() {return iProject.findAll();}

    @PostMapping("/add")
    public Project add(@RequestBody Project project) {return iProject.save(project);}

    @PutMapping("/update")
    public Project update(@RequestBody Project project) { return  iProject.save(project);}

    @DeleteMapping("/delete/{id}")
    public void delete (@PathVariable Integer id){iProject.deleteById(id);}


}
