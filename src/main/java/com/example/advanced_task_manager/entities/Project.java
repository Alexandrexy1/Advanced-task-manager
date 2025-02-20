package com.example.advanced_task_manager.entities;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;


@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private final String name;

    @NotNull
    private final String description;

    @NotNull
    private final Team team;

    @NotNull
    private final List<Task> tasks;

    public Project(@NotNull String name, @NotNull String description, @NotNull Team team, @NotNull List<Task> tasks) {
        this.name = name;
        this.description = description;
        this.team = team;
        this.tasks = tasks;
    }

    public Long getId() {
        return id;
    }

    public @NotNull String getName() {
        return name;
    }

    public @NotNull String getDescription() {
        return description;
    }

    public @NotNull Team getTeam() {
        return team;
    }

    public @NotNull List<Task> getTasks() {
        return tasks;
    }
}
