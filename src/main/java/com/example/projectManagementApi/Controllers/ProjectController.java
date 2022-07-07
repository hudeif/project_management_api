package com.example.projectManagementApi.Controllers;

import com.example.projectManagementApi.Custom.ProjectRequest;
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

    @GetMapping("/{id}")
    public Project getOne(@PathVariable Integer id) {return iProject.findById(id).get();}


    @PostMapping("/add")
    public Project add(@RequestBody ProjectRequest request) {
        Project project = new Project();
//        if(request.id == null){
//            project = new Project();
//        }else {
//            project = iProject.findById(request.id).get();
//        }

        project.setId(request.id);
        project.setProjectName(request.projectName);
        project.setDescription(request.description);
        project.setStartDate(request.startDate);
        project.setEndDate(request.endDate);
        project.setTasks(request.tasks);
        project.setMeeting(request.meeting);
        request.users.forEach(u -> {
            project.getUsers().add(u);
        });

        iProject.save(project);
        return null;
    }

    @PutMapping("/update")
    public Project update(@RequestBody Project project) { return  iProject.save(project);}

    @DeleteMapping("/delete/{id}")
    public void delete (@PathVariable Integer id){iProject.deleteById(id);}


}
