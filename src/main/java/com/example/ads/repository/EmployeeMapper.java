package com.example.ads.repository;

import com.example.ads.model.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface EmployeeMapper {
    Employee selectByCode(String code);
}