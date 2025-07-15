package com.mertspring.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class HelloWorldController {

    @GetMapping("/showForm")
    public String showForm(){
         return "helloworld-form";
    }

    @RequestMapping(value = "/processForm", method = RequestMethod.POST)
    public String processForm(){
        return "helloworld";
    }

    @RequestMapping("/processFormv2")
    public String letsShout(HttpServletRequest request, Model model){

        String name = request
                .getParameter("studentName")
                .toUpperCase();

        model.addAttribute("message", name);

        return "helloworld";
    }

    @RequestMapping(value = "/processFormv3",method = RequestMethod.POST)
    public String processFormv3(@RequestParam("studentName") String name, Model model){

        name = name.toUpperCase();

        String message = "Hello " + name + " Today is " + LocalDateTime.now();

        model.addAttribute("message", name);

        return "helloworld";
    }


}
