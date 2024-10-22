package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


//@ControllerAdvice + @ExceptionHandlar
//自定義每個Exception所返回的http response

//@ControllerAdvice
//只能加在class上
//講這個class變成一個bean，並且可以在內部使用 @ExceptionHandler
//@ControllerAdvice 的生效範圍依賴於 Spring 的組件掃描配置。只要這個異常處理器所在的包（或它的父包）是在 Spring Boot 主應用類（即 @SpringBootApplication 註解的類）的掃描範圍內，這個處理器就能夠自動作用於所有控制器。

//@ExceptionHandlar
//只能加在方法上
//去catch方法所噴出的Exception

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handle(RuntimeException exception) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body("Runtime Exception: " + exception.getMessage()); //503
    }
//    當controller裡的任何一個方法噴出Runtime的時候這個註解就會接住並且執行該方法

    //    Handle另一種error
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handle(IllegalArgumentException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("IllegalArgumentException: " + exception.getMessage());
    }


}
