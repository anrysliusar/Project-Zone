package com.sliusar.projectzone.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/developer/get")
    public String getAdmin() {
        return "q develop";
    }

    @GetMapping("/manager/get")
    public String getUser() {
        return "Nu zdraste manager";
    }
}
