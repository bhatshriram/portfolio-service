package com.service.portfolioservice.validators;

import com.service.portfolioservice.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SkillValidator {
    @Autowired
    private SkillRepository skillRepository;

    public void validateSkill(Long id) throws Exception {
        if(!skillRepository.existsById(id)) {
            throw new Exception("User not found!");
        }
    }
}
