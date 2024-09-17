package com.project.Scrum.APP.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.project.Scrum.APP.models.User;
import com.project.Scrum.APP.repositories.IUserRepository;

@Service
public class UserService {

    IUserRepository iUserRepository;


    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    public User createUser(User newUser) {
        return iUserRepository.save(newUser);
    }

    public void deleteUser(Integer id) {
        iUserRepository.deleteById(id);
    }

    public User updateUser(User user, Integer id){
        user.setId(id);
        return iUserRepository.save(user);
    }
    

    public List<User> getAllUsers(){
        return iUserRepository.findAll();

    
    }
    public User getUserById(int id) {
        Optional<User> user = iUserRepository.findById(id);
        return user.orElse(null);
        
    }

}
