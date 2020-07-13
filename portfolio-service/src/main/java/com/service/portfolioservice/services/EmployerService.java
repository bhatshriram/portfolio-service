package com.service.portfolioservice.services;

import com.service.portfolioservice.models.Employer;
import com.service.portfolioservice.models.User;
import com.service.portfolioservice.repositories.EmployerRepository;
import com.service.portfolioservice.validators.EmployerValidator;
import com.service.portfolioservice.validators.ProjectValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployerService {

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private EmployerValidator employerValidator;

    public List<Employer> getAllEmployers() {
        return employerRepository.findAll();
    }

    public Employer getEmployer(Long id) throws Exception {
        employerValidator.validateEmployer(id);
            return employerRepository.getOne(id);
    }

    public Employer addEmployer(Employer employer) {
        return employerRepository.saveAndFlush(employer);
    }

    public Employer updateEmployer(Long id, Employer employer) throws Exception {
        employerValidator.validateEmployer(id);
        Employer existingEmployer = employerRepository.getOne(id);
        BeanUtils.copyProperties(employer, existingEmployer, "employer_id");
        return employerRepository.saveAndFlush(existingEmployer);
    }

    public String deleteEmployer(Long id) throws Exception {
        employerRepository.deleteById(id);
        return "Employer Deleted Successfully!";
    }
}
