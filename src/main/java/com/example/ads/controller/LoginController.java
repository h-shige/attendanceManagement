package com.example.ads.controller;

import com.example.ads.model.EmployeeInnerJoinAuthority;
import com.example.ads.repository.EmployeeInnerJoinAuthorityMapper;
import com.example.ads.service.EmployeeInnerJoinAuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class LoginController {

    private final EmployeeInnerJoinAuthorityService service;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String showList(Authentication loginUser, Model model){
        String employeeCode = loginUser.getName();
        EmployeeInnerJoinAuthority user = service.selectByEmployeeCode(employeeCode);
        model.addAttribute("user", user);
        return "time-card";
    }
}
