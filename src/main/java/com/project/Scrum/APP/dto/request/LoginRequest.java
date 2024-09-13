package com.project.Scrum.APP.dto.request;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration

public class LoginRequest {
    String username;
    String password;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
