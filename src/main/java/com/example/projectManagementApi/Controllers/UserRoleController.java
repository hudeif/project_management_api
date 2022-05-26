package com.example.projectManagementApi.Controllers;

import com.example.projectManagementApi.Interfaces.IUserRole;
import com.example.projectManagementApi.Models.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("role")
@CrossOrigin(maxAge = 3600)
public class UserRoleController {
    @Autowired
    IUserRole iUserRole;

    @GetMapping("/list")
    public List<UserRole> getRoles(){
        return iUserRole.findAll();
    }

    @PostMapping("/add")
    public UserRole add(@RequestBody UserRole userRole){
        return iUserRole.save(userRole);
    }

    @PutMapping("/update")
    public UserRole update(@RequestBody UserRole userRole){
        return iUserRole.save(userRole);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id){
         iUserRole.deleteById(id);
    }

}
