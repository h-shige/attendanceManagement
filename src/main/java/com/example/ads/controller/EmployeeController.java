package com.example.ads.controller;

import com.example.ads.model.entity.Employee;
import com.example.ads.model.entity.EmployeeInnerJoinAuthority;
import com.example.ads.service.EmployeeInnerJoinAuthorityService;
import com.example.ads.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 従業員コントローラー
 */
@Controller
@RequiredArgsConstructor
public class EmployeeController {

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
    @GetMapping("/edit-employee")
    public String editEmployee(Model model) {
        model.addAttribute("user", user);
        model.addAttribute("editUser", employeeService.selectByCode(user.getEmployeeCode()));
        return "edit-employee-form";
    }

    /**
     * 従業員情報の更新をして、完了画面へ遷移するメソッド
     * @param editUser 新しい従業員情報を保持した従業員クラス
     */
    @PostMapping("/edit-employee-complete")
    public String editEmployeeComplete(@Validated Employee editUser,
                               BindingResult result, Model model) {
        model.addAttribute("user", user);
        if (result.hasErrors()) {
            model.addAttribute("editUser", editUser);
            return "edit-employee-form";
        }
        editUser.setPassword(passwordEncoder.encode(editUser.getPassword()));
        employeeService.updateByCode(editUser);
        user.setField(employeeInnerJoinAuthorityService.selectByEmployeeCode(editUser.getCode()));

        return "edit-employee-complete";
    }

    @GetMapping("/admin/create-employee-form")
    public String createEmployee(Employee newEmployee, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("newEmployee", newEmployee);
        return "create-employee-form";
    }

    @PostMapping("/admin/create-employee-confirmation")
    public String createEmployeeConfirmation(@Validated Employee newEmployee,
                                             BindingResult result, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("newEmployee", newEmployee);
        if (result.hasErrors()) return "create-employee-form";
        return "create-employee-confirmation";
    }

    @PostMapping("/admin/create-employee-complete")
    public String register(Employee newEmployee, Model model) {
        model.addAttribute("user", user);
        newEmployee.setPassword(passwordEncoder.encode(newEmployee.getPassword()));
        employeeService.insert(newEmployee);
        model.addAttribute("newEmployee",
                employeeInnerJoinAuthorityService.selectByEmployeeCode(newEmployee.getCode()));
        return "create-employee-complete";
    }

}
