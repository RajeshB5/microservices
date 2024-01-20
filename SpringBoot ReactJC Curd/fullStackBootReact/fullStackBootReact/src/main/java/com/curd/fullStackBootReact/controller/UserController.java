package com.curd.fullStackBootReact.controller;

import com.curd.fullStackBootReact.model.User;
import com.curd.fullStackBootReact.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    User newUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("/users")
    List<User> getUsers(){
        return userRepository.findAll();
    }
}
