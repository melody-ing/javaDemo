package com.example.demo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/* Request */
/*@RestController/@Controller*/
//把class變成bean
//讓這個class裡面可以用 @Request Mapping
//如果用 @Controller 則每個 Request class 前面都需要加上 @ResponseBody，@RestController 則不用
//自動轉換為 JSON 是因為 Spring Boot 自動配置了 Jackson 序列化庫，並且 @RestController 的作用是返回 JSON 格式的響應。

/* @RequestMapping */
//外面的class需要加上 @RestController
//加在class上或方法上，小括號裡填寫url路徑
//將url路徑對應到方法上

/* Response */
//@RequestParam => 取得url參數
//@RequestBody
//@RequestHeader
//@PathVariable

//@RequestParam
//只能加在方法參數上
//取得url裡面的參數

//@RequestBody
//只能加在方法的參數上
//取得request body裡面的參數(將Json轉為Java object)

//@RequestHeader
//只能加在方法的參數上
//取得request header裡面的參數

//@PathVariable
//只能加在方法的參數上
//取得url路徑的值
//有點像結合@RequestMapping & @ RequestParam

/* RESTful API method */
//@GetMapping("/userData") : 指定說只能用GET
//@PostMapping("/usersData") : 指定說只能用POST
//@PutMappint("/userData") : 指定說只能用PUT
//@DeleteMappint("/userData") : 指定說只能用DELETE

/* spring-boot-starter-validation */
//@RequestBody使用時要在方法參數前加上 @Valid
//@RequestParam, @RequestHeader, @PathVariable 使用時要在Controller參數前加上 @Validated

/* HTTP Status */
//ResponseEntity<?>
//系統response會自動會傳200 或 500，如果要自定義status code就要使用這個方法
//類別為ResponseEntity<回傳值的類別>
//回傳值要使用ResponseEntity.status(HttpStatus.要回傳的status code對應的單字).body(可以存放要回傳的值)


@RequestMapping("/detail")
@RestController
@Validated
@ControllerAdvice
public class MyController {
    @Autowired //在呼叫bean時需要寫這註解
    @Qualifier("hpPrinter") //呼叫bean時class的開頭是小寫
    private Printer printer;


    @GetMapping("/usersData/{userId}")
    public ResponseEntity<String> read(@PathVariable Integer userId) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Get Response");

    }

    @PostMapping("/usersData")
    //這個註解就會把這個path去找到對應的usersData方法上
    public Users usersData(@RequestBody @Valid Users users,//用於POST
                           @RequestHeader(required = false) String role,
                           @RequestHeader(name = "Content-type") String contentType) {

        //@RequestHeader常常會用到name來設定，因為變數不能包含-，所以要另外取名才拿的到內建的Header
        System.out.println(role);
        return users;
    }

    @PutMapping("/usersData/{userId}")
    public Users update(@PathVariable Integer userId,
                        @RequestBody Users users) {
        return users;
    }

    @DeleteMapping("/usersData/{userId}")
    public String delete(@PathVariable Integer userId) {
        return "刪除資料";
    }


    @RequestMapping("/student/{id}")
    // (name = "userId") 可以透過name來改輸入資料的key名字
    // (required = false)  required設定是否為必要的參數 預設為true 可以改成false
    // (defaultValue = "Melody") 可以不傳入參數，若不傳入參數則會使用default的值
    public Student user(@PathVariable Integer id,
                        @RequestParam(defaultValue = "Melody") String name) {
        // 前端多傳的參數會被忽略
        Student student = new Student();
        student.setName(name);
        student.setId(id);
        List<String> list = new ArrayList<>();
        list.add("swim");
        list.add("soccer");
        student.setSportList(list);
        return student;
    }

    @RequestMapping("/exception1")
    public String test1() {
        throw new RuntimeException("test1 error");
    }

    @RequestMapping("/exception2")
    public String test2() {
        throw new IllegalArgumentException("test2 error");
    }


    @RequestMapping("/interceptor1")
    public String test3() {
        return "攔截器呦";
    }

    @RequestMapping("/interceptor2")
    public String test4() {
        return "第二個攔截器呦";
    }

}
