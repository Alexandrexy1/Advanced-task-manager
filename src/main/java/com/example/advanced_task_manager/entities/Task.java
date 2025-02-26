package com.example.advanced_task_manager.entities;

import com.example.advanced_task_manager.enums.Priority;
import com.example.advanced_task_manager.enums.Status;
import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private final String title;

    @NotNull
    private final String description;

    @NotNull
    private final Status status;

    @NotNull
    private final LocalDateTime deadline;

    private Priority priority;
    private List<String> tags;

    @OneToMany(mappedBy = "task")
    private final List<Historical> historical = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private final User user;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private final Project project;

    public Task(@NotNull String title, @NotNull String description, @NotNull Status status, @NotNull LocalDateTime deadline, User user, Project project) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.deadline = deadline;
        this.user = user;
        this.project = project;
    }

    public long getId() {
        return id;
    }

    public @NotNull String getTitle() {
        return title;
    }

    public @NotNull String getDescription() {
        return description;
    }

    public @NotNull Status getStatus() {
        return status;
    }

    public @NotNull LocalDateTime getDeadline() {
        return deadline;
    }

    public Priority getPriority() {
        return priority;
    }

    public List<String> getTags() {
        return tags;
    }

    public List<Historical> getHistorical() {
        return historical;
    }

    public User getUser() {
        return user;
    }

    public Project getProject() {
        return project;
    }
}
