package com.service.portfolioservice.validators;

import com.service.portfolioservice.repositories.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployerValidator {
    @Autowired
    private EmployerRepository employerRepository;

    public void validateEmployer(Long id) throws Exception {
        if(!employerRepository.existsById(id)) {
            throw new Exception("User not found!");
        }
    }
}
