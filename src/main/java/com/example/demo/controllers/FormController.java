package com.example.demo.controllers;

import com.example.demo.domain.Usuario;
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
        model.addAttribute("titulo", "Formulario de Usuario");
        return "form";
    }
    
    // Se extraen los valores a traves del protocolo http request
    @PostMapping("/form")
    public String procesar(Usuario usuario, Model model) { 
//        Se mappea de manera automatica al tener el mismo nombre de los campos en el html, es necesario tener setter en la entidad
        model.addAttribute("titulo", "Resultado Form");
        model.addAttribute("usuario", usuario);
        
        return "resultado";
    }
    
}
