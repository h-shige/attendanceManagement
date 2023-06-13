package com.example.ads.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Setter
@Getter
public class TimeCard {

    private Long id;

    private LocalDateTime attendance;

    private LocalDateTime leaving;

    private LocalTime workingHours;

    private Boolean isLeaving;

    private String employeeCode;

    public boolean hasNullField(){
        if (this.id == null) return true;
        if (this.attendance == null) return true;
        if (this.leaving == null) return true;
        if (this.workingHours == null) return true;
        if (this.isLeaving == null) return true;
        if (this.employeeCode == null) return true;
        if (this.employeeCode.isEmpty()) return true;
        return false;
    }

    public TimeCard attendance(EmployeeInnerJoinAuthority user) {
        LocalDateTime now = LocalDateTime.now();
        this.setAttendance(now);
        this.setEmployeeCode(user.getEmployeeCode());
        return this;
    }

    public TimeCard leaving(){
        this.setLeaving(LocalDateTime.now());
        Long workingTime = Duration.between(this.getAttendance(), this.getLeaving()).getSeconds();
        this.setWorkingHours(LocalTime.ofSecondOfDay(workingTime));
        this.setIsLeaving(true);
        return this;
    }
}
