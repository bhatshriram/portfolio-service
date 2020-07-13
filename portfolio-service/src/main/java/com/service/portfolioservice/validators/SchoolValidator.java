package com.service.portfolioservice.validators;

import com.service.portfolioservice.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SchoolValidator {
    @Autowired
    private SchoolRepository schoolRepository;

    public void validateSchool(Long id) throws Exception {
        if(!schoolRepository.existsById(id)) {
            throw new Exception("User not found!");
        }
    }
}
