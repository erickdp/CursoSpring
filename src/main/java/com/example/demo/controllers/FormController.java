package com.example.demo.controllers;

import com.example.demo.domain.Usuario;
import java.util.HashMap;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
    public String procesar(@Valid Usuario usuario, BindingResult result, Model model) { // En caso de errores en la validacion se usa binding, debe de estar siempre despues del objeto que se valida
        
        model.addAttribute("titulo", "Resultado Form");
        
        if(result.hasErrors()) {
            var errores = new HashMap<String, String>();
            result.getFieldErrors().forEach(err -> {
                errores.put(err.getField(), "El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage())); // Se obtiene el input donde fallo y el valor
            });
            model.addAttribute("error", errores);
            return "form";
        }
        
//        Se mappea de manera automatica al tener el mismo nombre de los campos en el html, es necesario tener setter en la entidad
        model.addAttribute("usuario", usuario);
        
        return "resultado";
    }
    
}
