package com.example.ads.repository;

import com.example.ads.model.entity.EmployeeInnerJoinAuthority;
import com.example.ads.model.entity.TimeCard;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

/**
 * タイムカードクラスのマッパー
 */
@Mapper
public interface TimeCardMapper {

    /**
     *
     * @param user
     * @return
     */
    TimeCard selectByEmployeeCodeAndIsLeavingFalse(EmployeeInnerJoinAuthority user);

    List<TimeCard> selectByEmployeeCode(EmployeeInnerJoinAuthority user);

    List<TimeCard> selectAttendanceYearAndMonthList(EmployeeInnerJoinAuthority user);

    List<TimeCard> selectByEmployeeCodeAndDate(int attendanceYear,
                                               int attendanceMonth,
                                               EmployeeInnerJoinAuthority user);

    int insert(TimeCard timeCard);

    int updateByEmployeeCodeAndIsLeavingFalse(TimeCard timeCard);

}
