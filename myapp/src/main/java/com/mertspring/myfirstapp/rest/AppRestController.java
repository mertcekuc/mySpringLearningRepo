package com.mertspring.myfirstapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class AppRestController {

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
}
