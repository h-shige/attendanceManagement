package com.example.ads.controller;

import com.example.ads.model.dto.TimeCardDTO;
import com.example.ads.model.entity.EmployeeInnerJoinAuthority;
import com.example.ads.model.entity.TimeCard;
import com.example.ads.model.utility.TimeCardConvertToTimeCardDTO;
import com.example.ads.service.TimeCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;



@Controller
@RequiredArgsConstructor
public class AttendanceController {

    private final EmployeeInnerJoinAuthority user;

    private final TimeCardService service;

    @GetMapping("/attendance-status-confirmation")
    public String attendanceStatusConfirmation(Model model) {
        List<TimeCard> timeCardList = service.selectByEmployeeCode(user);
        TimeCardConvertToTimeCardDTO converter = new TimeCardConvertToTimeCardDTO(timeCardList);
        List<TimeCardDTO> timeCardDTOList = converter.createTimeCardDTOList();
        model.addAttribute("user", user);
        model.addAttribute("timeCardList", timeCardDTOList);
        return "attendance-status-confirmation";
    }


}
