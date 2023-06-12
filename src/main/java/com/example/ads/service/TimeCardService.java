package com.example.ads.service;

import com.example.ads.model.EmployeeInnerJoinAuthority;
import com.example.ads.model.TimeCard;
import com.example.ads.repository.TimeCardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class TimeCardService {

    private final TimeCardMapper mapper;

    public TimeCard selectByWorkingDate(LocalDate workingDate, EmployeeInnerJoinAuthority user){
        return mapper.selectByWorkingDate(workingDate, user);
    }
    public int insert(TimeCard timeCard) {
        return mapper.insert(timeCard);
    }

    public int updateByEmployeeCodeAndWorkingDate(TimeCard timeCard) {
        return mapper.updateByEmployeeCodeAndWorkingDate(timeCard);
    }
}
