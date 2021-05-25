package com.example.demo.controllers;

import com.example.demo.domain.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String procesar(Model model, 
            @RequestParam(name = "username") String username, // Se puede usar para definir que valor se usa para extraer
            @RequestParam String password,
            @RequestParam String email) {
        
        Usuario usuario = new Usuario(); // Corresponden a los pojos
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setEmail(email);
        
        model.addAttribute("titulo", "Resultado Form");
        model.addAttribute("usuario", usuario);
        
        return "resultado";
    }
    
}
