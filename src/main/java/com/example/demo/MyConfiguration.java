package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//其他創建Bean的方法

//同時使用@Configuration + @Bean
//@Configuration 只能加在class上，是Spring 中的設定用註解，表示這個class是拿來設定Spring的
//@Bean在Spring容器中創建一個Bean，只能在帶有@Configuration的Class中

@Configuration
public class MyConfiguration {

    //這個Bean的名稱是myPrinter
    //執行時會將HpPrinter放到Spring容器中
    @Bean
    public Printer myPrinter() {
        return new HpPrinter();
    }

    //    這樣就會在這個Spring容器中創建兩個Bean，所以在呼叫時一樣需要使用@Qualifier("yourPrinter") 來指定Bean
    @Bean
    public Printer yourPrinter() {
        return new CanonPrinter();
    }
}
