package com.example.hw7_spring_security.controller;

import com.example.hw7_spring_security.services.AdminService;
import com.example.hw7_spring_security.services.HomeService;
import com.example.hw7_spring_security.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class ControllerClass {

    private final HomeService homeService;
    private final UserService userService;
    private final AdminService adminService;

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("text", homeService.getText());
        return "index";
    }

    @GetMapping("/public-data")
    public String user(Model model) {
        model.addAttribute("text", userService.getText());
        return "public-data";
    }

    @GetMapping("/private-data")
    public String admin(Model model) {
        model.addAttribute("text", adminService.getText());
        return "private-data";
    }

}
