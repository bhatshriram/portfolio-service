package com.service.portfolioservice.services;

import com.service.portfolioservice.models.Project;
import com.service.portfolioservice.repositories.ProjectRepository;
import com.service.portfolioservice.validators.ProjectValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectValidator projectValidator;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project getProject(Long id) throws Exception {
        projectValidator.validateProject(id);
        return projectRepository.getOne(id);
    }

    public Project addProject(Project project) {
        return projectRepository.saveAndFlush(project);
    }

    public Project updateProject(Long id, Project project) throws Exception {
        projectValidator.validateProject(id);
        Project existingProject = projectRepository.getOne(id);
        BeanUtils.copyProperties(project, existingProject, "project_id");
        return projectRepository.saveAndFlush(existingProject);
    }

    public String deleteProject(Long id) throws Exception {
        projectRepository.deleteById(id);
        return "Project Deleted Successfully!";
    }
}
