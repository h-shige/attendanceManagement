package com.example.ads.model.entity;


import lombok.Getter;
import lombok.Setter;

/**
 * 従業員クラス
 * 従業員テーブルのエンティティ
 */
@Getter
@Setter
public class Employee {

    /** ID */
    private Long id;

    /** 従業員コード */
    private String code;

    /** 従業員氏名 */
    private String name;

    /** パスワード */
    private String password;

    /** 権限コード */
    private String authorityCode;

}