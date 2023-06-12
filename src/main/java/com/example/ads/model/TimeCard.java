package com.example.ads.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Setter
@Getter
public class TimeCard {

    private Long id;

    private LocalDate workingDate;

    private LocalDateTime attendance;

    private LocalDateTime leaving;

    private LocalTime workingHours;

    private String EmployeeCode;
}
