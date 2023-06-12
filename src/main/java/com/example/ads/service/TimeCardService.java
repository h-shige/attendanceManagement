package com.example.ads.service;

import com.example.ads.model.entity.EmployeeInnerJoinAuthority;
import com.example.ads.model.entity.TimeCard;
import com.example.ads.repository.TimeCardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class TimeCardService {

    private final TimeCardMapper mapper;

    public TimeCard selectByEmployeeCodeAndIsLeavingFalse(EmployeeInnerJoinAuthority user){
        return mapper.selectByEmployeeCodeAndIsLeavingFalse(user);
    }
    public int insert(TimeCard timeCard) {
        return mapper.insert(timeCard);
    }

    public int updateByEmployeeCodeAndIsLeavingFalse(TimeCard timeCard) {
        return mapper.updateByEmployeeCodeAndIsLeavingFalse(timeCard);
    }
}
