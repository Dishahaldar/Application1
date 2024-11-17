package com.example.assignmentsystem.service;

import com.example.assignmentsystem.model.Assignment;
import com.example.assignmentsystem.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    public List<Assignment> getAssignmentsByAdmin(String admin) {
        return assignmentRepository.findByAdmin(admin);
    }

    public Assignment saveAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public Assignment acceptAssignment(String id) {
        Assignment assignment = assignmentRepository.findById(id).orElse(null);
        if (assignment != null) {
            assignment.setAccepted(true);
            return assignmentRepository.save(assignment);
        }
        return null;
    }

    public Assignment rejectAssignment(String id) {
        Assignment assignment = assignmentRepository.findById(id).orElse(null);
        if (assignment != null) {
            assignment.setAccepted(false);
            return assignmentRepository.save(assignment);
        }
        return null;
    }
}
