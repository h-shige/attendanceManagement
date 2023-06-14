package com.example.ads.controller;

import com.example.ads.model.entity.EmployeeInnerJoinAuthority;
import com.example.ads.service.EmployeeInnerJoinAuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ログインコントローラー
 */
@RequiredArgsConstructor
@Controller
public class LoginController {

    /** 従業員テーブルと権限テーブルの結合テーブルサービス */
    private final EmployeeInnerJoinAuthorityService service;

    /** 従業員テーブルと権限テーブルを結合したクラス */
    private final EmployeeInnerJoinAuthority user;

    /**
     * ログイン画面に遷移するメソッド
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * ログイン認証を経てトップページの打刻画面に遷移するメソッド
     * @param loginUser ログイン認証したユーザー
     */
    @GetMapping("/")
    public String home(Authentication loginUser, Model model){
        String employeeCode = loginUser.getName();
        user.setField(service.selectByEmployeeCode(employeeCode));
        model.addAttribute("user", user);
        return "time-card";
    }

}
