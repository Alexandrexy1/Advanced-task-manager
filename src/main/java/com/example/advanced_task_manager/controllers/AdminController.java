package com.example.advanced_task_manager.controllers;

import com.example.advanced_task_manager.dto.UserDetailsDTO;
import com.example.advanced_task_manager.entities.User;
import com.example.advanced_task_manager.repositories.UserRepository;
import com.example.advanced_task_manager.roles.Role;
import com.example.advanced_task_manager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/users")
    public ResponseEntity<List<UserDetailsDTO>> findAll() {
        List<UserDetailsDTO> usersDetails = userService.findAll();
        return new ResponseEntity<>(usersDetails, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDetailsDTO> findById(@PathVariable long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        if(user.getRole() == null) user.setRole(Role.ROLE_USER);

        return new ResponseEntity<>(
                new UserDetailsDTO(user.getId(), user.getName(), user.getEmail(),
                        List.of(new SimpleGrantedAuthority(user.getRole().name()))), HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id) {
        if (userRepository.existsById(id)) {
            userService.deleteById(id);
            return new ResponseEntity<>("User deleted",HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
