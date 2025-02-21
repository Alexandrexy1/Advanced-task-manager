package com.example.advanced_task_manager.dto;

import com.example.advanced_task_manager.roles.Role;

public record UserDetailsDTO(String name, String email, Role role) {
}
