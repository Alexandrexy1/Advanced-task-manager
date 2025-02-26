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
    private String name;

    @Column(unique = true, nullable = false)
    private String email;
    private String password;

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

    @OneToMany(mappedBy = "user")
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

    public User() {

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

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(@Nullable Role role) {
        this.role = role;
    }
}
