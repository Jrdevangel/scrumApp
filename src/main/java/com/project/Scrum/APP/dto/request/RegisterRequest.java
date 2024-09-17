package com.project.Scrum.APP.dto.request;
import com.project.Scrum.APP.models.ERole;

public class RegisterRequest {
    private String username;
    private String email;
    private String password;
    private ERole role;

    public RegisterRequest() {
    }

    private RegisterRequest(Builder builder) {
        this.username = builder.username;
        this.email = builder.email;
        this.password = builder.password;
        this.role = builder.role;
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

    public static class Builder {
        private String username;
        private String email;
        private String password;
        private ERole role;

        public Builder() {
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setRole(ERole role) {
            this.role = role;
            return this;
        }

        public RegisterRequest build() {
            return new RegisterRequest(this);
        }
    }
}
