package com.service.portfolioservice.validators;

import com.service.portfolioservice.repositories.ProjectRepository;
import com.service.portfolioservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjectValidator {

    @Autowired
    private ProjectRepository projectRepository;

    public void validateProject(Long id) throws Exception {
        if(!projectRepository.existsById(id)) {
            throw new Exception("User not found!");
        }
    }
}
