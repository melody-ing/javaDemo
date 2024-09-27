package com.example.demo;

/* Spring IoC = inversion of control */
//將object的控制權交給了外部的Spring容器來處理

//優點
//1. Loose coupling 鬆耦合
//2. Lifecycle management 生命週期管理

/* 創建BEAN */
//1. @Component
//2. 同時使用@Configuration + @Bean

//創建bean時要加@Component這個註解
//1. 只能加在class上
//2. 程式啟動時會將該class變成由Spring所管理的object
//3. 被Spring容器創建的object叫做bean
//4. bean的名字為class的名字，只是第一個字母轉為小寫

//呼叫bean
//1. 只有一樣是bean的component可以呼叫bean
//2. 創建bean的註解有很多種 ex. @Component, @RestController
//3. 呼叫bean時需要寫@Autowired的註解
//4. 當Spring把存放在Spring容器裡的bean交給另一個bean叫做DI(Dependency Injection 依賴注入)
//5. private Printer printer; 呼叫的時候使用interface來當作型別，因為一個類別允許使用父類別型別的引用來指向子類別的物件

//@Autowired
//通常加在class變數上
//根據變數的類型去Spring容器中找有沒有符合的bean

//@Qualifier
//當有多個bean時可以指定要載入的bean的名字

/* 初始化BEAN */
//1. 使用@PostConstruct(主要)
//2. 實現InitializingBean interface 的 afterPropertiesSet() 方法

/* BEAN 的生命週期 */
//1.啟動Spring boot後，會啟動一個空的Spring容器出來
//2.創建Bean object放在Spring容器裡面
//3.對Bean進行初始化
//4.運行成功

/* @Value */
//加在Bean或是設定Spring用的class裏面的變數上
//讀取Spring Boot 設定檔(application.properties)中指定的key的值
//只能叫application.properties或是application.yml


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HpPrinter implements Printer {
    @Value("${printer.count:20}")
//    如果在properties檔案找不到這個value就會使用變數後面冒號的預設值
    private int count;

    @Value("${printer.name}")
//    呼叫application裡面的值，存到name裡面
//    習慣會將變數存在那裏
    private String name;

//    初始化這個bean，加上@PostConstruct註解，並且一定要是public方法
//    @PostConstruct
//    public void init() {
//        count = 5;
//    }


    @Override

// 實現介面時，需要定義介面中的所有方法，並且要設定成public
    public void print(String message) {
        System.out.println("HP印表機 " + message); //sout
    }
}
