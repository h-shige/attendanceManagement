package com.example.ads.repository;

import com.example.ads.model.entity.Authority;
import org.apache.ibatis.annotations.Mapper;

/**
 * オーソリティマッパー
 */
@Mapper
public interface AuthorityMapper {

    /**
     * 　権限コードを用いて権限テーブルを検索するメソッド
     * @param code 権限コード
     * @return 引数で指定した権限コードと同じ権限コードを持つ権限クラスのインスタンス
     */
    Authority selectByCode(String code);
}
