package com.example.ads.repository;

import com.example.ads.model.entity.EmployeeInnerJoinAuthority;
import com.example.ads.model.entity.TimeCard;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;

@Mapper
public interface TimeCardMapper {

    TimeCard selectByEmployeeCodeAndIsLeavingFalse(EmployeeInnerJoinAuthority user);

    int insert(TimeCard timeCard);

    int updateByEmployeeCodeAndIsLeavingFalse(TimeCard timeCard);

}
