package com.example.demo.form;

import lombok.Data;

@Data
public class UserForm {
    private String name;  // 名前
    private String ruby;  // フリガナ
    private String gender; // 性別
    private String hobby; // 趣味
    private String introduction; // 一言
}