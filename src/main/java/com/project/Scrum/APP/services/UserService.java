package com.project.Scrum.APP.services;

import com.project.Scrum.APP.repositories.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private IUserRepository iUserRepository;


    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }
}
