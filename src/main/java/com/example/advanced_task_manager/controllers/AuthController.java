package com.example.advanced_task_manager.controllers;

import com.example.advanced_task_manager.dto.LoginUserDTO;
import com.example.advanced_task_manager.dto.RegisterUserDTO;
import com.example.advanced_task_manager.dto.UserDetailsDTO;
import com.example.advanced_task_manager.entities.User;
import com.example.advanced_task_manager.infra.security.TokenService;
import com.example.advanced_task_manager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
            return new ResponseEntity<>("User created, token: " + token, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public ResponseEntity<UserDetailsDTO> login(@RequestBody LoginUserDTO dto) {
        User entity = repository.findByEmail(dto.email()).orElseThrow(() -> new RuntimeException("User not found"));
        if (encoder.matches(dto.password(), entity.getPassword())) {
            String token = service.generateToken(entity);
            return new ResponseEntity<>(
                    new UserDetailsDTO(entity.getId(), entity.getName(),
                            entity.getEmail(), List.of(new SimpleGrantedAuthority(entity.getRole().name()))), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
