package com.example.ads.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
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

    private String EmployeeCode;

}
