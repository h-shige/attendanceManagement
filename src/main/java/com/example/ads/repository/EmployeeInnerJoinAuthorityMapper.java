package com.example.ads.repository;

import com.example.ads.model.EmployeeInnerJoinAuthority;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface EmployeeInnerJoinAuthorityMapper {
    Optional<EmployeeInnerJoinAuthority> selectByEmployeeName(String employeeName);

    Optional<EmployeeInnerJoinAuthority> selectByEmployeeCode(String employeeCode);
}