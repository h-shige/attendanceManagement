package com.example.ads.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

/**
 * 従業員テーブルと権限テーブルの結合クラス
 */
@Getter
@Setter
@ToString
@SessionScope
@Component
public class EmployeeInnerJoinAuthority {

    /** 従業員 */
    private Long employeeId;

    /** 従業員コード */
    private String employeeCode;

    /** 従業員名 */
    private String employeeName;

    /** パスワード */
    private String password;

    /** 権限名 */
    private String authorityName;

    /**
     * フィールド代入メソッド
     * @param employeeInnerJoinAuthority 従業員テーブルと権限テーブルの結合クラス
     */
    public void setField(EmployeeInnerJoinAuthority employeeInnerJoinAuthority) {
        this.employeeId = employeeInnerJoinAuthority.getEmployeeId();
        this.employeeCode = employeeInnerJoinAuthority.getEmployeeCode();
        this.employeeName = employeeInnerJoinAuthority.getEmployeeName();
        this.password = employeeInnerJoinAuthority.getPassword();
        this.authorityName = employeeInnerJoinAuthority.getAuthorityName();
    }

}