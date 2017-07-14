# Kotlin Android Hands-on

## 題材

GitHubのリポジトリをキーワード検索するアプリを作成します。

![rocket](https://raw.github.com/ntaro/kotlin-android-hands-on/master/art/capture.gif)

## 事前準備とスタート

ハンズオンは[masterブランチ](https://github.com/ntaro/kotlin-android-hands-on)から始めます。

このブランチは、コードや各種設定が記述済みです。
ハンズオン開始までに **ビルド** と **実行** をしておいてください。

コードは未完成で、ハンズオンの中で完成させていきます。

## 完成形

[completedブランチ](https://github.com/ntaro/kotlin-android-hands-on/tree/completed)は、完成形です。

## ハンズオン課題

### `Repository`クラスの定義

GitHub上に存在するリポジトリを表現するクラスを定義しましょう。

プロパティ名|型|説明
---|---|---
`id`|`Long`|ID
`fullName`|`String`|フルネーム＝「ユーザ名/リポジトリ名」
`htmlUrl`|`String`|詳細URL
`stargazersCount`|`Int`|スター数
`owner`|`User`|リポジトリの所有者。Userクラスは定義済み
`description`|`String?`|リポジトリの説明
`language`|`String?`|言語

### ダミーデータのリスト表示

### インテント生成関数 + リポジトリ詳細画面

### Retrofitを使ってAPIアクセス

### async/awaitの体験

### スター付けた人のリスト表示機能を作る