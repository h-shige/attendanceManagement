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
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;



@Controller
@RequiredArgsConstructor
public class AttendanceStatusController {

    private final EmployeeInnerJoinAuthority user;

    private final TimeCardService service;

    @GetMapping("/attendance-status-selection")
    public String attendanceStatusConfirmation(Model model) {
        List<TimeCard> timeCardList = service.selectAttendanceYearAndMonthList();
        model.addAttribute("user", user);
        model.addAttribute("timeCardList", timeCardList);
        return "attendance-status-selection";
    }

    @GetMapping("/attendance-status-confirmation/{attendanceYear}/{attendanceMonth}")
    public String attendanceStatusConfirmation(@PathVariable int attendanceYear,
                                               @PathVariable int attendanceMonth,
                                               Model model) {
        TimeCardConvertToTimeCardDTO converter =
                new TimeCardConvertToTimeCardDTO(service.selectByEmployeeCodeAndDate(attendanceYear, attendanceMonth, user));
        List<TimeCardDTO> timeCardList = converter.createTimeCardDTOList();
        model.addAttribute("timeCardList", timeCardList);
        model.addAttribute("user", user);
        return "attendance-status-confirmation";
    }


}
