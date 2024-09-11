package com.project.Scrum.APP.services;


import com.project.Scrum.APP.models.User;
import com.project.Scrum.APP.repositories.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private IUserRepository iUserRepository;


    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    public User updateUser(User user, Integer id){
        user.setId(id);
        return iUserRepository.save(user);
    }
}
