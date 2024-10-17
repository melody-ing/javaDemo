package com.example.demo;

//右鍵Generate可以自動創建getter setter
//需要 getter 和 setter 是為了遵循面向對象編程中的封裝性原則，保護對象內部的數據。

import java.util.List;

public class Student {
    Integer id;
    String name;
    List<String> sportList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //    Getter用於取得值
    public String getName() {
        return name;
    }

    //Setter用於設置值
    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSportList() {
        return sportList;
    }

    public void setSportList(List<String> sportList) {
        this.sportList = sportList;
    }
}
