package com.project.Scrum.APP.dto.response;

import com.project.Scrum.APP.models.ERole;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthResponse {
    String token;
    ERole role;

    public AuthResponse(String token, ERole role) {
        this.token = token;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public ERole getRole() {
        return role;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setRole(ERole role) {
        this.role = role;
    }
}
