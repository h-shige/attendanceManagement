package com.example.ads.model.dto;

import com.example.ads.model.entity.TimeCard;
import lombok.Getter;

import java.time.format.DateTimeFormatter;

/**
 * タイムカードDTO
 * 勤怠状況を画面に表示する際に都合の良いフィールドを保持するクラス
 */
@Getter
public class TimeCardDTO {

    /**
     * コンストラクタ
     * @param timeCard タイムカードのエンティティ、全てのフィールドが代入されているもの以外受け付けない。
     * @throws IllegalAccessException 引数が不正であった場合にスローされる
     */
    public TimeCardDTO(TimeCard timeCard) throws IllegalAccessException {
        if (timeCard == null) throw new IllegalAccessException("引数がnullです。");
        if (timeCard.hasNullField()) throw new IllegalAccessException("引数のインスタンスにnull、または空のフィールドがあります。");
        this.attendanceDate = timeCard.getAttendance().toLocalDate().format(dateFormatter);
        this.attendanceTime = timeCard.getAttendance().toLocalTime().format(timeFormatter);
        this.leavingDate = timeCard.getLeaving().toLocalDate().format(dateFormatter);
        this.leavingTime = timeCard.getLeaving().toLocalTime().format(timeFormatter);
        this.workingHours = timeCard.getWorkingHours().format(timeFormatter);
    }

    /** 時間のフォーマット */
    private static final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    /** 日付のフォーマット */
    private static final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    /** 出勤日 */
    private final String attendanceDate;

    /** 出勤時間 */
    private final String attendanceTime;

    /** 退勤日 */
    private final String leavingDate;

    /** 退勤時間 */
    private final String leavingTime;

    /** 勤務時間 */
    private final String workingHours;


}
