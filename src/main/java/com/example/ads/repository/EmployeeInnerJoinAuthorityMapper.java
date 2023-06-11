package com.example.ads.repository;

import com.example.ads.model.EmployeeInnerJoinAuthority;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeInnerJoinAuthorityMapper {
    EmployeeInnerJoinAuthority selectByEmployeeName(String employeeName);

    EmployeeInnerJoinAuthority selectByEmployeeCode(String employeeCode);
}