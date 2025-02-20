package com.example.advanced_task_manager.entities;

import com.example.advanced_task_manager.dto.RegisterUserDTO;
import com.example.advanced_task_manager.roles.Role;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private final String name;

    @NotNull
    private final String email;

    @NotNull
    private final String password;

    @Nullable
    private Role role;

    @ManyToMany
    @JoinTable(
            name = "user_team",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    @NotNull
    private final List<Team> teams = new ArrayList<>();

    @OneToMany
    @NotNull
    private final List<Task> tasks = new ArrayList<>();

    public User(@NotNull String name, @NotNull String email, @NotNull String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User(RegisterUserDTO dto) {
        name = dto.name();
        email = dto.email();
        password = dto.password();
    }

    public Long getId() {
        return id;
    }

    public @NotNull String getName() {
        return name;
    }

    public @NotNull String getEmail() {
        return email;
    }

    public @NotNull String getPassword() {
        return password;
    }

    public @Nullable Role getRole() {
        return role;
    }

    public @NotNull List<Team> getTeams() {
        return teams;
    }

    public @NotNull List<Task> getTasks() {
        return tasks;
    }
}
