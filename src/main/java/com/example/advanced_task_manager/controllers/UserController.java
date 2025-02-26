package com.example.advanced_task_manager.controllers;

import com.example.advanced_task_manager.dto.CustomUserDetails;
import com.example.advanced_task_manager.dto.UserDetailsDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/me")
public class UserController {
    //@GetMapping
    //public ResponseEntity<UserDetailsDTO> profile(@AuthenticationPrincipal CustomUserDetails userDetails) {
    //    return new ResponseEntity<>(new UserDetailsDTO(), HttpStatus.OK);
    //}
}
