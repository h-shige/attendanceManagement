package com.example.ads.controller;

import com.example.ads.model.entity.EmployeeInnerJoinAuthority;
import com.example.ads.model.entity.TimeCard;
import com.example.ads.service.TimeCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

@RequiredArgsConstructor
@Controller
public class TimeCardController {

    private final TimeCardService service;

    private final EmployeeInnerJoinAuthority user;

    @GetMapping("/attendance")
    public String attendance(Model model) {
        LocalDateTime now = LocalDateTime.now();
        TimeCard timeCard = new TimeCard();
        timeCard.setAttendance(now);
        timeCard.setEmployeeCode(user.getEmployeeCode());
        service.insert(timeCard);
        model.addAttribute("user", user);
        return "attendance-complete";
    }

    @GetMapping("/leaving")
    public String leaving(Model model) {
        TimeCard timeCard = service.selectByEmployeeCodeAndIsLeavingFalse(user);
        timeCard.setLeaving(LocalDateTime.now());
        Long workingTime = Duration.between(timeCard.getAttendance(), timeCard.getLeaving()).getSeconds();
        timeCard.setWorkingHours(LocalTime.ofSecondOfDay(workingTime));
        timeCard.setIsLeaving(true);
        service.updateByEmployeeCodeAndIsLeavingFalse(timeCard);
        model.addAttribute("user", user);
        return "leaving-complete";
    }
}
