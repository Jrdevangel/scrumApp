package com.project.Scrum.APP.config;

import com.project.Scrum.APP.jwt.AuthTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class WebConfigSecurity {

    public WebConfigSecurity(AuthenticationProvider authenticationProvider, AuthTokenFilter authTokenFilter) {
        this.authenticationProvider = authenticationProvider;
        this.authTokenFilter = authTokenFilter;
    }

    private final AuthenticationProvider authenticationProvider;
    private final AuthTokenFilter authTokenFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        return http
                .csrf(csrf->
                        csrf.disable())
                .authorizeHttpRequests(authRequest ->
                        authRequest
                                .requestMatchers("/api/auth/**").permitAll()
                                .requestMatchers("/api/test/all").permitAll()
                                .requestMatchers("/api/test/user").hasAnyAuthority("ADMIN", "USER")
                                .requestMatchers("/api/test").hasAuthority("ADMIN")
                                .requestMatchers("/api/tasks").hasAuthority("ADMIN")
                                .requestMatchers("/api/tasks/**").hasAuthority("ADMIN")
                                .requestMatchers("/api/tasks/**").hasAuthority("ADMIN")
                                .requestMatchers("/api/tasks/").hasAuthority("ADMIN")
                                .requestMatchers("/api/projects").permitAll()
                                .requestMatchers("/api/projects/**").hasAuthority("ADMIN")
                                .requestMatchers("/api/projects/**").hasAuthority("ADMIN")
                                .requestMatchers("/api/projects").permitAll()
                                .requestMatchers("/api/users").permitAll()
                                .requestMatchers("/api/users/**").hasAuthority("ADMIN")
                                .requestMatchers("/api/users/**").hasAuthority("ADMIN")
                                .requestMatchers("/api/users").permitAll()
                                .anyRequest().authenticated()
                )
                .sessionManagement(sessionManager ->
                        sessionManager
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
