package com.service.portfolioservice.controllers;

import com.service.portfolioservice.models.Skill;
import com.service.portfolioservice.models.Skill;
import com.service.portfolioservice.services.SkillService;
import com.service.portfolioservice.utils.PortfolioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/v1/skills")
public class SkillController {
    @Autowired
    private SkillService skillService;

    @GetMapping()
    public PortfolioResponse getAllSkills(HttpServletResponse response) {
        PortfolioResponse portfolioResponse = new PortfolioResponse();
        try{
            List<Skill> skills= skillService.getAllSkills();
            portfolioResponse.setBody(skills);
            portfolioResponse.setStatusCode(200);
            portfolioResponse.setSuccessMessage("Success!");
        }
        catch(Exception e) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            portfolioResponse.setStatusCode(404);
            portfolioResponse.setFailMessage("Skills data not found");
        }
        return portfolioResponse;
    }

    @GetMapping
    @RequestMapping(value = "{id}")
    public PortfolioResponse getSkill(@PathVariable Long id, HttpServletResponse response) throws Exception {
        PortfolioResponse portfolioResponse = new PortfolioResponse();
        try{
            Skill skill= skillService.getSkill(id);
            portfolioResponse.setBody(skill);
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
    public  PortfolioResponse addSkill(@RequestBody final Skill skill, HttpServletResponse response) {
        PortfolioResponse portfolioResponse = new PortfolioResponse();
        try{
            Skill skill1= skillService.addSkill(skill);
            portfolioResponse.setBody(skill1);
            portfolioResponse.setStatusCode(200);
            portfolioResponse.setSuccessMessage("Success!");
        }
        catch(Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            portfolioResponse.setStatusCode(500);
            portfolioResponse.setFailMessage("Failed to add skill");
        }
        return portfolioResponse;
    }

    @RequestMapping(value="{id}", method= RequestMethod.PUT)
    public PortfolioResponse updateSkill(@PathVariable Long id,@RequestBody Skill skill, HttpServletResponse response) throws Exception {
        PortfolioResponse portfolioResponse = new PortfolioResponse();
        try{
            Skill skill1= skillService.updateSkill(id, skill);
            portfolioResponse.setBody(skill1);
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
    public PortfolioResponse deleteSkill(@PathVariable Long id, HttpServletResponse response) throws Exception {
        PortfolioResponse portfolioResponse = new PortfolioResponse();
        try{
            String status= skillService.deleteSkill(id);
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
