package com.example.ads.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * タイムカードテーブルのエンティティ
 */
@Setter
@Getter
public class TimeCard {

    /** ID */
    private Long id;

    /** 出勤日時 */
    private LocalDateTime attendance;

    /** 出勤年 */
    private int attendanceYear;

    /** 出勤月 */
    private int attendanceMonth;

    /** 退勤日時 */
    private LocalDateTime leaving;

    /** 勤務時間 */
    private LocalTime workingHours;

    /** 退勤フラグ */
    private Boolean isLeaving;

    /** 従業員コード */
    private String employeeCode;

    /**
     * nullまたは不正な値があるかどうか確認するメソッド
     * @return nullまたは不正な値がある場合true,ない場合はfalse
     */
    public boolean hasNullField(){
        if (this.id == null) return true;
        if (this.attendance == null) return true;
        if (this.attendanceYear < 0) return true;
        if (this.attendanceMonth < 0) return true;
        if (this.attendanceMonth > 12) return true;
        if (this.leaving == null) return true;
        if (this.workingHours == null) return true;
        if (this.isLeaving == null) return true;
        if (this.employeeCode == null) return true;
        if (this.employeeCode.isEmpty()) return true;
        return false;
    }

    /**
     * 出勤時にフィールドに代入するメソッド
     * @param user ログインしているユーザー
     * @return 出勤時に必要なフィールドが代入されたタイムカードクラスのインスタンス
     */
    public TimeCard attendance(EmployeeInnerJoinAuthority user) {
        LocalDateTime now = LocalDateTime.now();
        this.setAttendance(now);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String[] attendanceDate = now.toLocalDate().format(dateFormatter).split("/");
        this.attendanceYear = Integer.parseInt(attendanceDate[0]);
        this.attendanceMonth = Integer.parseInt(attendanceDate[1]);
        this.setEmployeeCode(user.getEmployeeCode());
        return this;
    }

    /**
     * 退勤時にフィールドに代入するメソッド
     * @return 退勤時に必要なフィールドが代入されたタイムカードクラスのインスタンス
     */
    public TimeCard leaving(){
        this.setLeaving(LocalDateTime.now());
        Long workingTime = Duration.between(this.getAttendance(), this.getLeaving()).getSeconds();
        this.setWorkingHours(LocalTime.ofSecondOfDay(workingTime));
        this.setIsLeaving(true);
        return this;
    }
}
