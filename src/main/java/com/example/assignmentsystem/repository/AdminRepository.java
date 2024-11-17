package com.example.assignmentsystem.repository;

import com.example.assignmentsystem.model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepository extends MongoRepository<Admin, String> {
    Admin findByUsername(String username);
}

