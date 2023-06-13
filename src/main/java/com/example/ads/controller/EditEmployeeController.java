package com.example.ads.controller;

import com.example.ads.model.entity.Employee;
import com.example.ads.model.entity.EmployeeInnerJoinAuthority;
import com.example.ads.service.EmployeeInnerJoinAuthorityService;
import com.example.ads.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 従業員情報編集コントローラー
 */
@Controller
@RequiredArgsConstructor
public class EditEmployeeController {

    /** 従業員サービス */
    private final EmployeeService employeeService;

    /** パスワードハッシュ化クラス */
    private final PasswordEncoder passwordEncoder;

    /** 従業員テーブルと権限テーブルの結合テーブルサービス */
    private final EmployeeInnerJoinAuthorityService employeeInnerJoinAuthorityService;

    /** 従業員テーブルと権限テーブルの結合テーブルサービス */
    private final EmployeeInnerJoinAuthority user;

    /**
     * 従業員情報編集フォームに遷移するメソッド
     */
    @GetMapping("/edit-employee-form")
    public String editEmployee(Model model) {
        model.addAttribute("user", user);
        model.addAttribute("editUser", employeeService.selectByCode(user.getEmployeeCode()));
        return "edit-employee-form";
    }

    /**
     * 従業員情報の更新をして、完了画面へ遷移するクラス
     * @param editUser 新しい従業員情報を保持した従業員クラス
     */
    @PostMapping("/edit-employee-complete")
    public String editEmployee(@ModelAttribute Employee editUser,
                               Model model) {
        editUser.setPassword(passwordEncoder.encode(editUser.getPassword()));
        employeeService.updateByCode(editUser);
        user.setField(employeeInnerJoinAuthorityService.selectByEmployeeCode(editUser.getCode()));
        model.addAttribute("user", user);
        return "edit-employee-complete";
    }

}
