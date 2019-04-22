package com.baizhi.controller;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("test")
@RestController
public class Test {
    @Autowired
    private DruidDataSource druidDataSource;

    @RequestMapping("test")
    public  void test(){

        System.out.println("aaa");
    }
}
