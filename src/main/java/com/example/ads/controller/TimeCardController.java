package com.example.ads.controller;

import com.example.ads.model.entity.EmployeeInnerJoinAuthority;
import com.example.ads.model.entity.TimeCard;
import com.example.ads.service.TimeCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 打刻コントローラー
 */
@RequiredArgsConstructor
@Controller
public class TimeCardController {

    /** タイムカードサービス */
    private final TimeCardService service;

    /** 従業員テーブルと権限テーブルを結合したクラス */
    private final EmployeeInnerJoinAuthority user;

    /**
     * サイドバーやボタンで打刻画面に遷移するメソッド
     */
    @PostMapping("/time-card")
    public String timeCard(Model model) {
        model.addAttribute("user", user);
        return "time-card";
    }

    /**
     * 出勤時に必要な情報をデータベースに登録し出勤完了画面に遷移するメソッド
     */
    @GetMapping("/attendance")
    public String attendance(Model model) {
        TimeCard timeCard = new TimeCard().attendance(user);
        service.insert(timeCard);
        model.addAttribute("user", user);
        return "attendance-complete";
    }

    /**
     * 退勤時に必要な情報をデータベースに登録し退勤完了画面に遷移するメソッド
     */
    @GetMapping("/leaving")
    public String leaving(Model model) {
        TimeCard timeCard = service.selectByEmployeeCodeAndIsLeavingFalse(user).leaving();
        service.updateByEmployeeCodeAndIsLeavingFalse(timeCard);
        model.addAttribute("user", user);
        return "leaving-complete";
    }

}
