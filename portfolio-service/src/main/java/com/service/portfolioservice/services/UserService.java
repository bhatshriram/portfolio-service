package com.service.portfolioservice.services;

import com.service.portfolioservice.models.User;
import com.service.portfolioservice.repositories.UserRepository;
import com.service.portfolioservice.validators.UserValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) throws Exception {
            userValidator.validateUser(id);
            return userRepository.getOne(id);
    }

    public User addUser(User user) {
        return userRepository.saveAndFlush(user);
    }

    public User updateUser(Long id, User user) throws Exception {
        userValidator.validateUser(id);
        User existingUser = userRepository.getOne(id);
        BeanUtils.copyProperties(user, existingUser, "user_id");
        return userRepository.saveAndFlush(existingUser);
    }

    public String deleteUser(Long id) throws Exception {
        userValidator.validateUser(id);
        userRepository.deleteById(id);
        return "User Deleted Successfully!";
    }
}
