package com.service.portfolioservice.controllers;

import com.service.portfolioservice.models.Employer;
import com.service.portfolioservice.models.Employer;
import com.service.portfolioservice.services.EmployerService;
import com.service.portfolioservice.services.EmployerService;
import com.service.portfolioservice.utils.PortfolioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employers")
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    @GetMapping()
    public PortfolioResponse getAllEmployers(HttpServletResponse response) {
        PortfolioResponse portfolioResponse = new PortfolioResponse();
        try{
            List<Employer> employers= employerService.getAllEmployers();
            portfolioResponse.setBody(employers);
            portfolioResponse.setStatusCode(200);
            portfolioResponse.setSuccessMessage("Success!");
        }
        catch(Exception e) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            portfolioResponse.setStatusCode(404);
            portfolioResponse.setFailMessage("Employers data not found");
        }
        return portfolioResponse;
    }

    @GetMapping
    @RequestMapping(value = "{id}")
    public PortfolioResponse getEmployer(@PathVariable Long id, HttpServletResponse response) throws Exception {
        PortfolioResponse portfolioResponse = new PortfolioResponse();
        try{
            Employer employer= employerService.getEmployer(id);
            portfolioResponse.setBody(employer);
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
    public  PortfolioResponse addEmployer(@RequestBody final Employer employer, HttpServletResponse response) {
        PortfolioResponse portfolioResponse = new PortfolioResponse();
        try{
            Employer employer1= employerService.addEmployer(employer);
            portfolioResponse.setBody(employer1);
            portfolioResponse.setStatusCode(200);
            portfolioResponse.setSuccessMessage("Success!");
        }
        catch(Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            portfolioResponse.setStatusCode(500);
            portfolioResponse.setFailMessage("Failed to add employer");
        }
        return portfolioResponse;
    }

    @RequestMapping(value="{id}", method= RequestMethod.PUT)
    public PortfolioResponse updateEmployer(@PathVariable Long id,@RequestBody Employer employer, HttpServletResponse response) throws Exception {
        PortfolioResponse portfolioResponse = new PortfolioResponse();
        try{
            Employer employer1= employerService.updateEmployer(id, employer);
            portfolioResponse.setBody(employer1);
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
    public PortfolioResponse deleteEmployer(@PathVariable Long id, HttpServletResponse response) throws Exception {
        PortfolioResponse portfolioResponse = new PortfolioResponse();
        try{
            String status= employerService.deleteEmployer(id);
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
