package com.project.Scrum.APP.dto.request;
import com.project.Scrum.APP.models.ERole;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RegisterRequest {
    String username;
    String email;
    String password;
    ERole role;

    public RegisterRequest(String username, String email, String password, ERole role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public ERole getRole() {
        return role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(ERole role) {
        this.role = role;
    }
}
