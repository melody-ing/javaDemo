package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/* Interceptor */
//class 上面要加上 @Component 註解以及 implements HandlerInterceptor，這個class就會變成攔截器
//可以用generate產生來決定要@Override哪些方法
//返回boolean
//根據返回的boolean來決定要不要允許這次的request
//ex.只有帶上某些header的才可以通過

//三種方法
//preHandle：判斷這個HTTP Request有沒有問題，沒問題在執行方法
//postHandle：方法執行後才執行
//afterHandle：方法執行後才執行

@Component
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("執行 MyInterceptor");
        return true;
    }
}
