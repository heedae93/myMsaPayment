package com.mymsapayment;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.mymsapayment")
public class MembershipMain {
    public static void main(String[] args) {
        SpringApplication.run(MembershipMain.class, args);
    }
}