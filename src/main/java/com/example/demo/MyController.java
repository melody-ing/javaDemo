package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @Autowired //在呼叫bean時需要寫這註解
    @Qualifier("hpPrinter") //呼叫bean時class的開頭是小寫
    private Printer printer;

    @RequestMapping("/test")
    public String test() {
        printer.print("hello world");
        return "hi";
    }
}
