package com.example.ads.controller;

import com.example.ads.service.EmployeeInnerJoinAuthorityService;
import com.example.ads.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class EditEmployeeController {

    private final EmployeeInnerJoinAuthorityService employeeInnerJoinAuthorityService;
    private final EmployeeService employeeService;

    @GetMapping("/edit-employee-form/{code}")
    public String editEmployee(@PathVariable String code, Model model) {
        model.addAttribute("user",
                employeeInnerJoinAuthorityService.selectByEmployeeCode(code));
        model.addAttribute("editUser", employeeService.selectByCode(code));
        return "edit-employee-form";
    }
}
