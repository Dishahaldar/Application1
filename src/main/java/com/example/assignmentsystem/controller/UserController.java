package com.example.assignmentsystem.controller;

import com.example.assignmentsystem.model.Assignment;
import com.example.assignmentsystem.model.User;
import com.example.assignmentsystem.service.UserService;
import com.example.assignmentsystem.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user) {
        return userService.findByUsername(user.getUsername());
    }

    @PostMapping("/upload")
    public Assignment uploadAssignment(@RequestBody Assignment assignment) {
        return assignmentService.saveAssignment(assignment);
    }
}
