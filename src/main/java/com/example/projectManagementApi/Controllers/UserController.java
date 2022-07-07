package com.example.projectManagementApi.Controllers;

import com.example.projectManagementApi.Interfaces.IUser;
import com.example.projectManagementApi.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("user")
public class UserController {
    @Autowired
    IUser iUser;

    @PostMapping("/check")
    public Map<String,Object> check(@RequestBody User user){
        Map<String,Object> response = new HashMap<>();
        User u = iUser.checkUser(user.getEmail(),user.getPassword());
        if(u != null){
            response.put("text","success");
            response.put("user",u);
        }else {
            response.put("text","not found!");
        }
        return response;
    }

    @GetMapping("/list")
    public List<User> users (){return iUser.findAll();}

    @PostMapping("/add")
    public User add(@RequestBody User user){
        User u;
        if(user.getId() == null){
             u =new User();
        }else {
         u = iUser.findById(user.getId()).get();
        }
        u.setId(user.getId());
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setEmail(user.getEmail());
        u.setUserRole(user.getUserRole());
        return iUser.save(u);
    }

    @PutMapping("/update")
    public User update(@RequestBody User user ) {
        User u = iUser.findById(user.getId()).get();
        u.setId(user.getId());
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setEmail(user.getEmail());
        u.setUserRole(user.getUserRole());

        return iUser.save(u);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) { iUser.deleteById(id);}

}
