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

@Controller
@RequiredArgsConstructor
public class EditEmployeeController {

    private final EmployeeService employeeService;

    private final PasswordEncoder passwordEncoder;

    private final EmployeeInnerJoinAuthorityService employeeInnerJoinAuthorityService;

    private final EmployeeInnerJoinAuthority user;

    @GetMapping("/edit-employee-form")
    public String editEmployee(Model model) {
        model.addAttribute("user", user);
        model.addAttribute("editUser", employeeService.selectByCode(user.getEmployeeCode()));
        return "edit-employee-form";
    }

    @PostMapping("/edit-employee-complete")
    public String editEmployee(@ModelAttribute Employee editUser,
                               Model model) {
        editUser.setPassword(passwordEncoder.encode(editUser.getPassword()));
        employeeService.updateByCode(editUser);
        user.setData(employeeInnerJoinAuthorityService.selectByEmployeeCode(editUser.getCode()));
        model.addAttribute("user", user);
        return "edit-employee-complete";
    }

    @PostMapping("/time-card")
    public String timeCard(Model model) {
        model.addAttribute("user", user);
        return "time-card";
    }
}
