package com.example.ads.repository;

import com.example.ads.model.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper {
    Employee selectByCode(String code);

    int updateByCode(Employee employee);
}