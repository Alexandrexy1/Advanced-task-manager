package com.example.advanced_task_manager.entities;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private final String name;

    @ManyToMany(mappedBy = "teams")
    @NotNull
    private final List<User> members = new ArrayList<>();

    public Team(@NotNull  String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public @NotNull String getName() {
        return name;
    }

    public @NotNull List<User> getMembers() {
        return members;
    }
}
