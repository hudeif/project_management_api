package com.example.projectManagementApi.Controllers;

import com.example.projectManagementApi.Interfaces.IUser;
import com.example.projectManagementApi.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("user")
public class UserController {
    @Autowired
    IUser iUser;

    @GetMapping("/list")
    public List<User> users (){return iUser.findAll();}

    @PostMapping("/add")
    public User add(@RequestBody User user){ return iUser.save(user);}

    @PutMapping("/update")
    public User update(@RequestBody User user ) {return iUser.save(user);}

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) { iUser.deleteById(id);}

}
