# AttendanceManagement
Spring Bootで作成した勤怠管理システムです。

画面のレイアウト、デザイン等は

書籍　Spring Boot2入門:基礎から実演まで

著者　原田けいと、竹田甘地、Robert Segawa

のspring-security2を参考に作成しています。

## 使用技術
- 開発言語
  - Java
- プロジェクト管理ツール
  - Maven
- 使用フレームワーク
  - Java/Spring Boot
  - css/Bootstrap5
  - PostgreSQL/MyBatis
- DB
  - PostgreSQL
- view
  - Thymeleaf,HTML
  - css/Bootstrap5
- IDE 
  - IntelliJ

## 機能

ログイン以外の機能は未ログイン時に利用できません。

### 全てのユーザに許された機能
- ログイン、ログアウト
- 出勤打刻
- 退勤打刻
- 従業員情報編集
- 勤怠状況確認

### 管理者ユーザのみに許された機能
- 新規従業員登録
- 従業員一覧表示
- 他の従業員の勤怠状況確認
