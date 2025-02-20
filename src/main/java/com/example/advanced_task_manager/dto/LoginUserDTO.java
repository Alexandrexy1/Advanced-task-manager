package com.example.advanced_task_manager.dto;
import jakarta.validation.constraints.Email;
import org.jetbrains.annotations.NotNull;

public record LoginUserDTO(@NotNull @Email String email, @NotNull String password) {
}

