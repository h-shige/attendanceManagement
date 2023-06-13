package com.example.ads.model.entity;

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
    private String Code;

    /** 権限名 */
    private  String name;
}
