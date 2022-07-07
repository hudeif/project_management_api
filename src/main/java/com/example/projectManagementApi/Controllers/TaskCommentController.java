package com.example.projectManagementApi.Controllers;

import com.example.projectManagementApi.Interfaces.ITaskComment;
import com.example.projectManagementApi.Models.TaskComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("task-comment")
@CrossOrigin(maxAge = 3600)
public class TaskCommentController {
    @Autowired
    ITaskComment iTaskComment;

    @GetMapping("/list")
    public List<TaskComment> getList(){
        return iTaskComment.findAll();
    }

    @PostMapping("/add")
    public TaskComment add(@RequestBody TaskComment taskComment){
        return iTaskComment.save(taskComment);
    }

    @PutMapping("/update")
    public TaskComment update(@RequestBody TaskComment taskComment){
        return iTaskComment.save(taskComment);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
        iTaskComment.deleteById(id);
    }
}
