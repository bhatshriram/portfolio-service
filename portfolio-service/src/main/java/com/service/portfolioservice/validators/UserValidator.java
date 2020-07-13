package com.service.portfolioservice.validators;

import com.service.portfolioservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    @Autowired
    private UserRepository userRepository;

    public void validateUser(Long id) throws Exception {
            if(!userRepository.existsById(id)) {
                throw new Exception("User not found!");
            }
    }

}
