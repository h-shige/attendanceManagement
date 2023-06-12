package com.example.ads.service;

import com.example.ads.model.entity.Employee;
import com.example.ads.repository.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeMapper mapper;

    public Employee selectByCode(String code) {
        return mapper.selectByCode(code);
    }

    public int updateByCode(Employee employee) {
        return mapper.updateByCode(employee);
    }
}
