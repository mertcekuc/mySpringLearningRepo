package com.mertspring.validationdemo.controller;

import com.mertspring.validationdemo.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;

@Controller
public class CustomerController {

   @InitBinder
   public void initBinder(WebDataBinder dataBinder){

       StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

       dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
   }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String showForm(Model model){

        model.addAttribute("customer",new Customer());

        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult result){

        if(result.hasErrors()){
                return "customer-form";}
        else{
            return "customer-confirmation";}
    }

}
