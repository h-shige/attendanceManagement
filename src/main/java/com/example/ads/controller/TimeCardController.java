package com.example.ads.controller;

import com.example.ads.model.entity.EmployeeInnerJoinAuthority;
import com.example.ads.model.entity.TimeCard;
import com.example.ads.service.TimeCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class TimeCardController {

    private final TimeCardService service;

    private final EmployeeInnerJoinAuthority user;

    @GetMapping("/attendance")
    public String attendance(Model model) {
        TimeCard timeCard = new TimeCard().attendance(user);
        service.insert(timeCard);
        model.addAttribute("user", user);
        return "attendance-complete";
    }

    @GetMapping("/leaving")
    public String leaving(Model model) {
        TimeCard timeCard = service.selectByEmployeeCodeAndIsLeavingFalse(user).leaving();
        service.updateByEmployeeCodeAndIsLeavingFalse(timeCard);
        model.addAttribute("user", user);
        return "leaving-complete";
    }
}
