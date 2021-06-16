package com.sliusar.projectzone.controllers;

import com.sliusar.projectzone.services.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class TestController {

    UserServiceImpl userService;

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String homePage(Principal principal){
        return "home";
    }

    @GetMapping("/authenticated")
    public String pageForAuthenticatedUsers(Principal principal){
        return "secured part of web service:" + principal.getName();
    }

    @GetMapping("/read_profile")
    public String pageForReadProfile(){
        return "read_profile page";
    }

    @GetMapping("/only_for_admins")
    public String pageOnlyForAdmins(){
        return "admins only";
    }

}
