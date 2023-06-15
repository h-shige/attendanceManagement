package com.example.ads.service;

import com.example.ads.model.entity.EmployeeInnerJoinAuthority;
import com.example.ads.repository.EmployeeInnerJoinAuthorityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeInnerJoinAuthorityService {

    private final EmployeeInnerJoinAuthorityMapper mapper;

    public List<EmployeeInnerJoinAuthority> selectAll() {
        return mapper.selectAll();
    }

    public EmployeeInnerJoinAuthority selectByEmployeeCode(String employeeCode) {
        return mapper.selectByEmployeeCode(employeeCode);
    }
}
