package com.example.advanced_task_manager.controllers;

import com.example.advanced_task_manager.dto.RegisterUserDTO;
import com.example.advanced_task_manager.entities.User;
import com.example.advanced_task_manager.infra.security.TokenService;
import com.example.advanced_task_manager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private TokenService service;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterUserDTO dto) {
        Optional<User> entity = repository.findByEmail(dto.email());
        if (entity.isEmpty()) {
            User user = new User();
            user.setPassword(encoder.encode(dto.password()));
            user.setEmail(dto.email());
            user.setName((dto.name()));
            repository.save(user);
            String token = service.generateToken(user);
            System.out.println("eu gerei o token no controller");
            return new ResponseEntity<>("User created: " + token, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
