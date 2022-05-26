package com.example.projectManagementApi.Controllers;

import com.example.projectManagementApi.Interfaces.ITask;
import com.example.projectManagementApi.Models.Task;
import com.example.projectManagementApi.Models.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("task")
@CrossOrigin(maxAge = 3600)
public class TaskController {
    @Autowired
    ITask iTask;

    @GetMapping("/list")
    public List<Task> getList(){
        return iTask.findAll();
    }

    // under review
    @PostMapping("/add")
    public Task add(@RequestBody Task task){
        return iTask.save(task);
    }

    @PutMapping("/update")
    public Task update(@RequestBody Task task){
        return iTask.save(task);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        iTask.deleteById(id);
    }
}
