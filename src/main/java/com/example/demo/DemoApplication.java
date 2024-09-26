package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
// @叫做annotation (標記或註解)
// @SpringBootApplication要加在class上 加上這個class就會有撥放鍵，就可以運行spring boot

//Spring boot 運行順序
//1.啟動Spring boot
//2.Spring 去檢查Class上的註解
//    (1)Class上有@Component註解，創建Bean
//    (2)Class上有@Configuration註解，用class裡面的code去設定Spring
//    (3)甚麼註解都沒有加就會當成普通的class
//3.啟動成功
public class DemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}



