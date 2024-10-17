package com.example.demo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/* spring-boot-starter-validation */
//使用時方法參數前需要加上 @Valid

//@Notnull：驗證有沒有輸入這個參數，要引入套件
//@NotBlank：不能為null、且不能為空白的字串，用在驗證String類型的參數上
//@NotEmpty：不能為null、且size>0，用在驗證集合類型(List、Set、Map)的參數上
//@Min(value)：值必須>=value，用在驗證數字類型的參數上
//@Max(value)：值必須<=value，用在驗證數字類型的參數上
//@Size(min,max)：min <= 字串長度 or 集合的 size <= max，可以只設 max or min
//@Email：必須符合電子郵件的格式
//@Pattern(regexp):必須符合正規表達式
//@Past：必須比當前時間早，也就是被註解的參數必須是以前的時間
//@Future:必須比當前時間晚，也就是被註解的參數必須是未來的時間
//@AssertTrue：必須為true,用在boolean類型的參數上
//@AssertFalse：必須為false,用在boolean類型的參數上
//@Null：必須為null

public class Users {
    @NotNull //一定要輸入id
    @Max(100)
    Integer id;

    @NotBlank
    String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
