package com.example.pract5.controller;

import com.example.pract5.model.Contact;
import com.example.pract5.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
    @Autowired
    private ContactService contactService;

    @GetMapping("/phoneBook")
    public String getHomePage(){
        return "index";
    }

    @GetMapping("/createContact")
    public String getCreationPage(){
        return "create";
    }

    @GetMapping("/editContact/{id}")
    public String getEditPage(){
        return "edit";
    }

    @GetMapping("/")
    public String getDefaultPage(){
        return "redirect:/phoneBook";
    }
}
