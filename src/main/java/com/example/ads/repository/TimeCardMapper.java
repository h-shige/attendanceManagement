package com.example.ads.repository;

import com.example.ads.model.EmployeeInnerJoinAuthority;
import com.example.ads.model.TimeCard;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;

@Mapper
public interface TimeCardMapper {

    TimeCard selectByWorkingDate(LocalDate workingDate, EmployeeInnerJoinAuthority user);

    int insert(TimeCard timeCard);

    int updateByEmployeeCodeAndWorkingDate(TimeCard timeCard);

}
