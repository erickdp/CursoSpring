package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Erick Diaz
 */
@Controller
public class FormController {
    
    @GetMapping("/form")
    public String form(Model model) {
        return "form";
    }
    
    @PostMapping("/form")
    public String procesar(Model model) {
        return "resultado";
    }
    
}
