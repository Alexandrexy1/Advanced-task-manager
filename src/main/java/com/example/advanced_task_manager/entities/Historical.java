package com.example.advanced_task_manager.entities;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "historical")
public class Historical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private final Task task;

    @NotNull
    private final String action;

    @NotNull
    private final User user;

    @NotNull
    private final LocalDateTime date;

    public Historical(@NotNull Task task, @NotNull String action, @NotNull User user, @NotNull LocalDateTime date) {
        this.task = task;
        this.action = action;
        this.user = user;
        this.date = date;
    }

    public @NotNull Long getId() {
        return id;
    }

    public @NotNull Task getTask() {
        return task;
    }

    public @NotNull String getAction() {
        return action;
    }

    public @NotNull User getUser() {
        return user;
    }

    public @NotNull LocalDateTime getDate() {
        return date;
    }
}
