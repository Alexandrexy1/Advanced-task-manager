package com.example.advanced_task_manager.infra.security;

import com.example.advanced_task_manager.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

}
