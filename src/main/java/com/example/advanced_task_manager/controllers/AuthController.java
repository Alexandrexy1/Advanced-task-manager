package com.example.advanced_task_manager.controllers;

import com.example.advanced_task_manager.dto.RegisterUserDTO;
import com.example.advanced_task_manager.entities.User;
import com.example.advanced_task_manager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRepository repository;

    @PostMapping("/register")
    public ResponseEntity<String> register(RegisterUserDTO dto) {
        User entity = new User(dto);
        repository.save(entity);
        return new ResponseEntity<>("User created", HttpStatus.CREATED);
    }
}
