package com.example.ads.controller;

import com.example.ads.model.Employee;
import com.example.ads.model.EmployeeInnerJoinAuthority;
import com.example.ads.service.EmployeeInnerJoinAuthorityService;
import com.example.ads.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class EditEmployeeController {

    private final EmployeeService employeeService;

    private final PasswordEncoder passwordEncoder;

    private final EmployeeInnerJoinAuthorityService employeeInnerJoinAuthorityService;

    private final EmployeeInnerJoinAuthority user;

    @GetMapping("/edit-employee-form/{code}")
    public String editEmployee(@PathVariable String code, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("editUser", employeeService.selectByCode(code));
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
