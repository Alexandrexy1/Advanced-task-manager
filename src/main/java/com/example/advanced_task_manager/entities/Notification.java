package com.example.advanced_task_manager.entities;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;


@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private final String message;

    @NotNull
    private final User receiver;

    @NotNull
    private final LocalDateTime sendDate;

    @NotNull
    private final Boolean read;

    public Notification(@NotNull String message, @NotNull User receiver, @NotNull LocalDateTime sendDate, @NotNull Boolean read) {
        this.message = message;
        this.receiver = receiver;
        this.sendDate = sendDate;
        this.read = read;
    }

    public Long getId() {
        return id;
    }

    public @NotNull String getMessage() {
        return message;
    }

    public @NotNull User getReceiver() {
        return receiver;
    }

    public @NotNull LocalDateTime getSendDate() {
        return sendDate;
    }

    public @NotNull Boolean getRead() {
        return read;
    }
}
