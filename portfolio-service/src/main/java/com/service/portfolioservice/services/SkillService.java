package com.service.portfolioservice.services;

import com.service.portfolioservice.models.Skill;
import com.service.portfolioservice.repositories.SkillRepository;
import com.service.portfolioservice.validators.SkillValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SkillService {
    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private SkillValidator skillValidator;

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    public Skill getSkill(Long id) throws Exception {
        skillValidator.validateSkill(id);
        return skillRepository.getOne(id);
    }

    public Skill addSkill(Skill skill) {
        return skillRepository.saveAndFlush(skill);
    }

    public Skill updateSkill(Long id, Skill skill) throws Exception {
        skillValidator.validateSkill(id);
        Skill existingSkill = skillRepository.getOne(id);
        BeanUtils.copyProperties(skill, existingSkill, "skill_id");
        return skillRepository.saveAndFlush(existingSkill);
    }

    public String deleteSkill(Long id) throws Exception {
        skillRepository.deleteById(id);
        return "Skill Deleted Successfully!";
    }
}
