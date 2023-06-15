package com.example.ads.repository;

import com.example.ads.model.entity.EmployeeInnerJoinAuthority;
import com.example.ads.model.entity.TimeCard;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.util.List;

/**
 * タイムカードクラスのマッパー
 */
@Mapper
public interface TimeCardMapper {

    /**
     * 引数で指定したuserの退勤打刻をしていないレコードを検索する
     * @param user システムを利用しているユーザのインスタンス
     * @return 該当したタイムカードテーブルのレコード
     */
    TimeCard selectByEmployeeCodeAndIsLeavingFalse(EmployeeInnerJoinAuthority user);

    /**
     * 引数で指定したuserの全てのレコードを検索する
     * @param user システムを利用しているユーザのインスタンス
     * @return 該当したレコードのリスト
     */
    List<TimeCard> selectByEmployeeCode(EmployeeInnerJoinAuthority user);

    /**
     * 引数で指定したuserが出勤した年月を重複を省いて検索するメソッド
     * @param user システムを利用しているユーザのインスタンス
     * @return userが出勤した年月
     */
    List<TimeCard> selectAttendanceYearAndMonthList(EmployeeInnerJoinAuthority user);

    List<TimeCard> selectByEmployeeCodeAndDate(int attendanceYear,
                                               int attendanceMonth,
                                               EmployeeInnerJoinAuthority user);

    /**
     * 出勤時にレコードを新規作成するメソッド
     * @param timeCard 新規登録するレコード
     */
    int insert(TimeCard timeCard);

    /**
     * 退勤時にレコードを更新するするメソッド
     * @param timeCard 更新するレコード
     */
    int updateByEmployeeCodeAndIsLeavingFalse(TimeCard timeCard);

}
