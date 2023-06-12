package com.example.ads.repository;

import com.example.ads.model.entity.EmployeeInnerJoinAuthority;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeInnerJoinAuthorityMapper {
    EmployeeInnerJoinAuthority selectByEmployeeName(String employeeName);

    EmployeeInnerJoinAuthority selectByEmployeeCode(String employeeCode);
}