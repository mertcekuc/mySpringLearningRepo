package com.mertspring.myfirstapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class AppRestController {
    @Value("${benim.adim}")
    String ad;
    @Value("${benim.soyadim}")
    String soyad;

    @GetMapping("/")
    public String SayHello(){
        return "Hello World From Spring :))))))";
    }

    @GetMapping("/new")
    public String sayNew(){
        return "This is the new  after devtool TESTTT";
    }

    @GetMapping("/new2")
    public String saySecond(){
        return "This is second after devtool";
    }

    @GetMapping("/selam")
    public String saySelam(){
        return "selam benim adim " + ad + " " +soyad;
    }
}
