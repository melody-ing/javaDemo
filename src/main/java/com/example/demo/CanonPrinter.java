package com.example.demo;

//@Component
public class CanonPrinter implements Printer {

    @Override
    public void print(String message) {
        System.out.println("Canon印表機 " + message);
    }
}
