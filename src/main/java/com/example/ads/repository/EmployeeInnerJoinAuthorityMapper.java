package com.example.ads.repository;

import com.example.ads.model.entity.EmployeeInnerJoinAuthority;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 従業員テーブルと権限テーブルを結合したクラスマッパー
 */
@Mapper
public interface EmployeeInnerJoinAuthorityMapper {

    List<EmployeeInnerJoinAuthority> selectAll();

    /**
     * 従業員コードで従業員テーブルと権限テーブルを検索するメソッド
     * @param employeeCode 従業員コード
     * @return 引数で指定した従業員コードと一致する従業員コードを持つ
     * 従業員テーブルと権限テーブルを結合したクラスのインスタンス
     */
    EmployeeInnerJoinAuthority selectByEmployeeCode(String employeeCode);

}