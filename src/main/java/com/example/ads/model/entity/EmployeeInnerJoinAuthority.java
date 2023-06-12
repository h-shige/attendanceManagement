package com.example.ads.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Getter
@Setter
@ToString
@SessionScope
@Component
public class EmployeeInnerJoinAuthority {

    private Long employeeId;

    private String employeeCode;

    private String employeeName;

    private String password;

    private String authorityName;

    public void setData(EmployeeInnerJoinAuthority employeeInnerJoinAuthority) {
        this.employeeId = employeeInnerJoinAuthority.getEmployeeId();
        this.employeeCode = employeeInnerJoinAuthority.getEmployeeCode();
        this.employeeName = employeeInnerJoinAuthority.getEmployeeName();
        this.password = employeeInnerJoinAuthority.getPassword();
        this.authorityName = employeeInnerJoinAuthority.getAuthorityName();
    }

}