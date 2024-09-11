package com.project.Scrum.APP.services;

import com.project.Scrum.APP.models.User;
import com.project.Scrum.APP.repositories.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    IUserRepository iUserRepository;


    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    public User createUser(User newUser) {
        return iUserRepository.save(newUser);
    }
}
