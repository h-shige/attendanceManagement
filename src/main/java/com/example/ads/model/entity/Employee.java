package com.example.ads.model.entity;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    //ユニーク制約
    @NotBlank
    @Size(max = 8)
    private String code;

    /** 従業員氏名 */
    @NotBlank
    @Size(max = 40)
    private String name;

    /** パスワード */
    @NotBlank
    @Size(max = 255)
    private String password;

    /** 権限コード */
    private String authorityCode;

}