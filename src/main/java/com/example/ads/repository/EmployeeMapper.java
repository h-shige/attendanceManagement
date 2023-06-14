package com.example.ads.repository;

import com.example.ads.model.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * 従業員マッパー
 */
@Mapper
public interface EmployeeMapper {

    /**
     * 従業員コードでｍ従業員テーブルを検索するメソッド
     * @param code 従業員コード
     * @return 引数で指定した従業員コードと同じ従業員コードを持つ従業員クラスのインスタンス
     */
    Employee selectByCode(String code);

    /**
     * 引数で指定した従業員クラスが持つ従業員コードと同じ従業員コードを持つ
     * レコードの内容を更新するメソッド
     * @param employee 更新をかける従業員クラスのインスタンス
     * @return
     */
    int updateByCode(Employee employee);
}