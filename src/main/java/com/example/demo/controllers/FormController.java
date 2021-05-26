package com.example.demo.controllers;

import com.example.demo.domain.Usuario;
import com.example.demo.validation.UsuarioValidador;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author Erick Diaz
 */
@Controller
@SessionAttributes("user") // Este att se guarda en una session http, pero si se cambian se actualizan
public class FormController {
    
    @Autowired
    private UsuarioValidador validador;
    
    // El validador de las anotaciones por defecto se cambia por el personalizado
    @InitBinder 
    public void initBinder(WebDataBinder binder) { // Otra forma de validar los parametros enviados es usando este metodo
//        binder.setValidator(validador); Valida solo los datos definidos en la calse validador
        binder.addValidators(validador); // Valida todos
    }
    
    @GetMapping("/form")
    public String form(Model model) { // El objeto se inicializa y pasa al formulario de manera automatica o se puede hacer manual con model.add...
        Usuario usuario = new Usuario();
        usuario.setNombre("Erick");
        usuario.setApellido("Apellido");
        usuario.setIdentificador("123.232K");
        
        model.addAttribute("user", usuario);
        model.addAttribute("titulo", "Formulario de Usuario");
        return "form";
    }
    
    // Se extraen los valores a traves del protocolo http request
    @PostMapping("/form")
    public String procesar(@Valid @ModelAttribute("user") Usuario usuario, BindingResult result, Model model, SessionStatus status) { // En caso de errores en la validacion se usa binding, debe de estar siempre despues del objeto que se valida
        // ModdelAttribute se usa para definir con que nombre se va a pasar el objeto a la vista
        model.addAttribute("titulo", "Resultado Form");
        
        if(result.hasErrors()) {
            return "form";
        }
        
//        Se mappea de manera automatica al tener el mismo nombre de los campos en el html, es necesario tener setter en la entidad
//        model.addAttribute("usuario", usuario); // El Pojo usuario se pasa al formulario de manera automatica o manual
        status.setComplete(); // Limpia los datos usados en sessionAttributes
        return "resultado";
    }
    
}
