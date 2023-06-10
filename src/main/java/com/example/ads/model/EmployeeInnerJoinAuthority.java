package com.example.ads.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeInnerJoinAuthority {

    private Long employeeId;

    private String employeeCode;

    private String employeeName;

    private String password;

    private String authorityName;

}