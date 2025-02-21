package com.example.advanced_task_manager.controllers;

import com.example.advanced_task_manager.dto.UserDetailsDTO;
import com.example.advanced_task_manager.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;


    @GetMapping
    public ResponseEntity<List<UserDetailsDTO>> findAll() {
        List<UserDetailsDTO> usersDetails = userService.findAll();
        return new ResponseEntity<>(usersDetails, HttpStatus.OK);
    }
}
