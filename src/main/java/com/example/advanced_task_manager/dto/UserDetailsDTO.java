package com.example.advanced_task_manager.dto;

import com.example.advanced_task_manager.entities.User;
import com.example.advanced_task_manager.roles.Role;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;

public record UserDetailsDTO(@NotNull Long id, @NotNull String name, @NotNull String email, @NotNull Collection<? extends GrantedAuthority> roles) {

    @Override
    public String toString() {
        return "UserDetailsDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                '}';
    }
}
