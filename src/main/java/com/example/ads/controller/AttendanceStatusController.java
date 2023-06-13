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

/**
 * 勤怠状況コントローラー
 */
@Controller
@RequiredArgsConstructor
public class AttendanceStatusController {

    /** 従業員テーブルと権限テーブルの結合テーブル */
    private final EmployeeInnerJoinAuthority user;

    /** タイムカードサービス */
    private final TimeCardService service;

    /**
     * 閲覧する勤怠状況の年月の選択ページに遷移するメソッド
     */
    @GetMapping("/attendance-status-selection")
    public String attendanceStatusConfirmation(Model model) {
        List<TimeCard> timeCardList = service.selectAttendanceYearAndMonthList();
        model.addAttribute("user", user);
        model.addAttribute("timeCardList", timeCardList);
        return "attendance-status-selection";
    }

    /**
     * 選択した勤怠状況の年月のページに遷移するメソッド
     * @param attendanceYear 出勤年
     * @param attendanceMonth 出勤月
     */
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
