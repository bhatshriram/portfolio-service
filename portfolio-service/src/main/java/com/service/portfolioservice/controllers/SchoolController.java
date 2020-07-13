package com.service.portfolioservice.controllers;

import com.service.portfolioservice.models.School;
import com.service.portfolioservice.models.School;
import com.service.portfolioservice.services.SchoolService;
import com.service.portfolioservice.utils.PortfolioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;

    @GetMapping()
    public PortfolioResponse getAllSchools(HttpServletResponse response) {
        PortfolioResponse portfolioResponse = new PortfolioResponse();
        try{
            List<School> schools= schoolService.getAllSchools();
            portfolioResponse.setBody(schools);
            portfolioResponse.setStatusCode(200);
            portfolioResponse.setSuccessMessage("Success!");
        }
        catch(Exception e) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            portfolioResponse.setStatusCode(404);
            portfolioResponse.setFailMessage("Schools data not found");
        }
        return portfolioResponse;
    }

    @GetMapping
    @RequestMapping(value = "{id}")
    public PortfolioResponse getSchool(@PathVariable Long id, HttpServletResponse response) throws Exception {
        PortfolioResponse portfolioResponse = new PortfolioResponse();
        try{
            School school= schoolService.getSchool(id);
            portfolioResponse.setBody(school);
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
    public  PortfolioResponse addSchool(@RequestBody final School school, HttpServletResponse response) {
        PortfolioResponse portfolioResponse = new PortfolioResponse();
        try{
            School school1= schoolService.addSchool(school);
            portfolioResponse.setBody(school1);
            portfolioResponse.setStatusCode(200);
            portfolioResponse.setSuccessMessage("Success!");
        }
        catch(Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            portfolioResponse.setStatusCode(500);
            portfolioResponse.setFailMessage("Failed to add school");
        }
        return portfolioResponse;
    }

    @RequestMapping(value="{id}", method= RequestMethod.PUT)
    public PortfolioResponse updateSchool(@PathVariable Long id,@RequestBody School school, HttpServletResponse response) throws Exception {
        PortfolioResponse portfolioResponse = new PortfolioResponse();
        try{
            School school1= schoolService.updateSchool(id, school);
            portfolioResponse.setBody(school1);
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
    public PortfolioResponse deleteSchool(@PathVariable Long id, HttpServletResponse response) throws Exception {
        PortfolioResponse portfolioResponse = new PortfolioResponse();
        try{
            String status= schoolService.deleteSchool(id);
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
