package com.example.ads.model.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * 権限クラス
 * 権限テーブルのエンティティ
 */
@Getter
@Setter
public class Authority {

    /** ID */
    private long id;

    /** 権限コード */
    @NotBlank
    @Size(max = 8)
    //ユニーク制約
    private String Code;

    /** 権限名 */
    @NotBlank
    @Size(max = 40)
    private  String name;
}
