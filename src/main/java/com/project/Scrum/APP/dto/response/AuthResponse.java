package com.project.Scrum.APP.dto.response;

import com.project.Scrum.APP.models.ERole;

public class AuthResponse {
    String token;
    ERole role;

    private AuthResponse(Builder builder) {
        this.token = builder.token;
        this.role = builder.role;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String token;
        private ERole role;

        public Builder() {
        }

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public Builder role(ERole role) {
            this.role = role;
            return this;
        }

        public AuthResponse build() {
            return new AuthResponse(this);
        }
    }

    public AuthResponse() {
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
