package com.service.portfolioservice.controllers;
import com.service.portfolioservice.models.User;
import com.service.portfolioservice.services.UserService;
import com.service.portfolioservice.utils.PortfolioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public PortfolioResponse getAllUsers(HttpServletResponse response) {
        PortfolioResponse portfolioResponse = new PortfolioResponse();
        try{
            List<User> users= userService.getAllUsers();
            portfolioResponse.setBody(users);
            portfolioResponse.setStatusCode(200);
            portfolioResponse.setSuccessMessage("Success!");
        }
        catch(Exception e) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            portfolioResponse.setStatusCode(404);
            portfolioResponse.setFailMessage("Users data not found");
        }
        return portfolioResponse;
    }

    @GetMapping
    @RequestMapping(value = "{id}")
    public PortfolioResponse getUser(@PathVariable Long id, HttpServletResponse response) throws Exception {
        PortfolioResponse portfolioResponse = new PortfolioResponse();
        try{
            User user= userService.getUser(id);
            portfolioResponse.setBody(user);
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
    public  PortfolioResponse addUser(@RequestBody final User user, HttpServletResponse response) {
        PortfolioResponse portfolioResponse = new PortfolioResponse();
        try{
            User user1= userService.addUser(user);
            portfolioResponse.setBody(user1);
            portfolioResponse.setStatusCode(200);
            portfolioResponse.setSuccessMessage("Success!");
        }
        catch(Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            portfolioResponse.setStatusCode(500);
            portfolioResponse.setFailMessage("Failed to add user");
        }
        return portfolioResponse;
    }

    @RequestMapping(value="{id}", method= RequestMethod.PUT)
    public PortfolioResponse updateUser(@PathVariable Long id,@RequestBody User user, HttpServletResponse response) throws Exception {
        PortfolioResponse portfolioResponse = new PortfolioResponse();
        try{
            User user1= userService.updateUser(id, user);
            portfolioResponse.setBody(user1);
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
    public PortfolioResponse deleteUser(@PathVariable Long id, HttpServletResponse response) throws Exception {
        PortfolioResponse portfolioResponse = new PortfolioResponse();
        try{
            String status= userService.deleteUser(id);
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
