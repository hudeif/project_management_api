package com.example.projectManagementApi.Controllers;

import com.example.projectManagementApi.Interfaces.IUser;
import com.example.projectManagementApi.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(maxAge = 3600)
@RequestMapping("user")
public class UserController {
    @Autowired
    IUser iUser;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/check")
    public Map<String,Object> check(@RequestBody User user){
        Map<String,Object> response = new HashMap<>();
        
        // First try to find user by email only
        Optional<User> optionalUser = iUser.findAll().stream()
            .filter(u -> u.getEmail().equals(user.getEmail()))
            .findFirst();
        
        if(optionalUser.isPresent()) {
            User u = optionalUser.get();
            // Check if password matches (handle both BCrypt and plain text)
            if(passwordEncoder.matches(user.getPassword(), u.getPassword()) || 
               user.getPassword().equals(u.getPassword())) {
                response.put("text","success");
                response.put("user",u);
            } else {
                response.put("text","wrong password");
            }
        } else {
            response.put("text","not found!");
        }
        return response;
    }

    @GetMapping("/{userid}/{status}")
    public void changeStatus(@PathVariable String userid,@PathVariable String status){
        iUser.updateUserStatus(userid,status);
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
        u.setPassword(u.getPassword());
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
