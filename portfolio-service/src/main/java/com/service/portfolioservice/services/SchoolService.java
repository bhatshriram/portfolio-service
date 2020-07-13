package com.service.portfolioservice.services;

import com.service.portfolioservice.models.School;
import com.service.portfolioservice.repositories.SchoolRepository;
import com.service.portfolioservice.validators.SchoolValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private SchoolValidator schoolValidator;

    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public School getSchool(Long id) throws Exception {
        schoolValidator.validateSchool(id);
        return schoolRepository.getOne(id);
    }

    public School addSchool(School school) {
        return schoolRepository.saveAndFlush(school);
    }

    public School updateSchool(Long id, School school) throws Exception {
        schoolValidator.validateSchool(id);
        School existingSchool = schoolRepository.getOne(id);
        BeanUtils.copyProperties(school, existingSchool, "school_id");
        return schoolRepository.saveAndFlush(existingSchool);
    }

    public String deleteSchool(Long id) throws Exception {
        schoolRepository.deleteById(id);
        return "School Deleted Successfully!";
    }
}
