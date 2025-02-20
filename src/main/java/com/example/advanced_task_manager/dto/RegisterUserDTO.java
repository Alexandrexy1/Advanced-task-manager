package com.example.advanced_task_manager.dto;

import jakarta.validation.constraints.Email;
import org.jetbrains.annotations.NotNull;

public record RegisterUserDTO(@NotNull String name, @NotNull @Email String email, @NotNull String password) {
}
