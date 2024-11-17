package com.example.assignmentsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.assignmentsystem.model.Admin;
import com.example.assignmentsystem.model.Assignment;
import com.example.assignmentsystem.service.AdminService;
import com.example.assignmentsystem.service.AssignmentService;

/*import demp.demoproject.model.Admin;
import demp.demoproject.model.Assignment;
import demp.demoproject.service.AdminService;
import demp.demoproject.service.AssignmentService;*/

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping("/register")
    public Admin registerAdmin(@RequestBody Admin admin) {
        return adminService.saveAdmin(admin);
    }

    @PostMapping("/login")
    public Admin loginAdmin(@RequestBody Admin admin) {
        return adminService.findByUsername(admin.getUsername());
    }

    @GetMapping("/assignments")
    public List<Assignment> getAssignments(@RequestParam String admin) {
        return assignmentService.getAssignmentsByAdmin(admin);
    }

    @PostMapping("/assignments/{id}/accept")
    public Assignment acceptAssignment(@PathVariable String id) {
        return assignmentService.acceptAssignment(id);
    }

    @PostMapping("/assignments/{id}/reject")
    public Assignment rejectAssignment(@PathVariable String id) {
        return assignmentService.rejectAssignment(id);
    }
}
