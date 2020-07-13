package com.service.portfolioservice.controllers;

import com.service.portfolioservice.models.Project;
import com.service.portfolioservice.services.ProjectService;
import com.service.portfolioservice.utils.PortfolioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("api/v1/projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping()
    public PortfolioResponse getAllProjects(HttpServletResponse response) {
        PortfolioResponse portfolioResponse = new PortfolioResponse();
        try{
            List<Project> projects= projectService.getAllProjects();
            portfolioResponse.setBody(projects);
            portfolioResponse.setStatusCode(200);
            portfolioResponse.setSuccessMessage("Success!");
        }
        catch(Exception e) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            portfolioResponse.setStatusCode(404);
            portfolioResponse.setFailMessage("Projects data not found");
        }
        return portfolioResponse;
    }

    @GetMapping
    @RequestMapping(value = "{id}")
    public PortfolioResponse getProject(@PathVariable Long id, HttpServletResponse response) throws Exception {
        PortfolioResponse portfolioResponse = new PortfolioResponse();
        try{
            Project project= projectService.getProject(id);
            portfolioResponse.setBody(project);
            portfolioResponse.setStatusCode(200);
            portfolioResponse.setSuccessMessage("Success!");
        }
        catch(Exception e) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            portfolioResponse.setStatusCode(404);
            portfolioResponse.setFailMessage(e.getMessage());
        }
        return portfolioResponse;
    }

    @PostMapping
    public  PortfolioResponse addProject(@RequestBody final Project project, HttpServletResponse response) {
        PortfolioResponse portfolioResponse = new PortfolioResponse();
        try{
            Project project1= projectService.addProject(project);
            portfolioResponse.setBody(project1);
            portfolioResponse.setStatusCode(200);
            portfolioResponse.setSuccessMessage("Success!");
        }
        catch(Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            portfolioResponse.setStatusCode(500);
            portfolioResponse.setFailMessage("Failed to add project");
        }
        return portfolioResponse;
    }

    @RequestMapping(value="{id}", method= RequestMethod.PUT)
    public PortfolioResponse updateProject(@PathVariable Long id,@RequestBody Project project, HttpServletResponse response) throws Exception {
        PortfolioResponse portfolioResponse = new PortfolioResponse();
        try{
            Project project1= projectService.updateProject(id, project);
            portfolioResponse.setBody(project1);
            portfolioResponse.setStatusCode(200);
            portfolioResponse.setSuccessMessage("Success!");
        }
        catch(Exception e) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            portfolioResponse.setStatusCode(404);
            portfolioResponse.setFailMessage(e.getMessage());
        }
        return portfolioResponse;
    }

    @RequestMapping(value="{id}", method= RequestMethod.DELETE)
    public PortfolioResponse deleteProject(@PathVariable Long id, HttpServletResponse response) throws Exception {
        PortfolioResponse portfolioResponse = new PortfolioResponse();
        try{
            String status= projectService.deleteProject(id);
            portfolioResponse.setBody(status);
            portfolioResponse.setStatusCode(200);
            portfolioResponse.setSuccessMessage("Success!");
        }
        catch(Exception e) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            portfolioResponse.setStatusCode(404);
            portfolioResponse.setFailMessage(e.getMessage());
        }
        return portfolioResponse;
    }

}
