package com.example.advanced_task_manager.services;
import com.example.advanced_task_manager.dto.UserDetailsDTO;
import com.example.advanced_task_manager.entities.User;
import com.example.advanced_task_manager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<UserDetailsDTO> findAll() {
        return repository.findAll().stream().map(
                user -> new UserDetailsDTO(user.getName(), user.getEmail(), user.getRole())).toList();
    }
}
