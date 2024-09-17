package com.project.Scrum.APP.dto.request;


public class LoginRequest {
    private String username;
    private String password;

    private LoginRequest(Builder builder) {
        this.username = builder.username;
        this.password = builder.password;
    }

    public LoginRequest() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public static class Builder {
        private String username;
        private String password;

        public Builder() {
        }

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public LoginRequest build() {
            return new LoginRequest(this);
        }
    }
}
