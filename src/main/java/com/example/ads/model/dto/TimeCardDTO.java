package com.example.ads.model.dto;

import com.example.ads.model.entity.TimeCard;

import java.time.format.DateTimeFormatter;

public class TimeCardDTO {

    public TimeCardDTO(TimeCard timeCard) throws IllegalAccessException {
        if (timeCard == null) throw new IllegalAccessException("引数がnullです。");
        if (timeCard.hasNullField()) throw new IllegalAccessException("引数のインスタンスにnull、または空のフィールドがあります。");
        this.attendanceDate = timeCard.getAttendance().toLocalDate().format(dateFormatter);
        this.attendanceTime = timeCard.getAttendance().toLocalTime().format(timeFormatter);
        this.leavingDate = timeCard.getLeaving().toLocalDate().format(dateFormatter);
        this.leavingTime = timeCard.getLeaving().toLocalTime().format(timeFormatter);
        this.workingHours = timeCard.getWorkingHours().format(timeFormatter);
    }

    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    private final String attendanceDate;

    private final String attendanceTime;

    private final String leavingDate;

    private final String leavingTime;

    private final String workingHours;


}
