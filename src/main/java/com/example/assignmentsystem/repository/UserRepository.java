package com.example.assignmentsystem.repository;

import com.example.assignmentsystem.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    User findByUsername(String username);
}

