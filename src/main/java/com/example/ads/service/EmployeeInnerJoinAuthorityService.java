package com.example.ads.service;

import com.example.ads.model.EmployeeInnerJoinAuthority;
import com.example.ads.repository.EmployeeInnerJoinAuthorityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeInnerJoinAuthorityService {

    private final EmployeeInnerJoinAuthorityMapper mapper;

    public EmployeeInnerJoinAuthority selectByEmployeeCode(String employeeCode) {
        return mapper.selectByEmployeeCode(employeeCode);
    }
}
