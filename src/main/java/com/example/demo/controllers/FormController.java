package com.example.demo.controllers;

import com.example.demo.domain.Pais;
import com.example.demo.domain.Role;
import com.example.demo.domain.Usuario;
import com.example.demo.editors.NombreMayusculaEditor;
import com.example.demo.editors.PaisPropertyEditor;
import com.example.demo.editors.RolePropertyEditor;
import com.example.demo.services.PaisService;
import com.example.demo.services.RoleService;
import com.example.demo.validation.UsuarioValidador;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
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

    @Autowired
    private PaisService paisService;

    @Autowired
    private PaisPropertyEditor paisPropertyEditor;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RolePropertyEditor rolePropertyEditor;

    // El validador de las anotaciones por defecto se cambia por el personalizado
    @InitBinder
    public void initBinder(WebDataBinder binder) { // Otra forma de validar los parametros enviados es usando este metodo
//        binder.setValidator(validador); Valida solo los datos definidos en la calse validador
        binder.addValidators(validador); // Valida todos

        var sdf = new SimpleDateFormat("yyyy-MM-dd"); // Solo este formato es valido para las fechas en html
        sdf.setLenient(false); // Permite que no haya fechas sin formatos, no es tolerante
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));

//        Registramos para que se pueda usar mayusculas
        binder.registerCustomEditor(String.class, "nombre", new NombreMayusculaEditor()); // Pasamos nuestro custom editor y el campo específico a pasarlo a mayus, si no se define lo toma para todos los campos
        binder.registerCustomEditor(String.class, "apellido", new NombreMayusculaEditor());

//        Se registra para poder validar el objeto de pais pero debo de enviar solamente el valor de id
        binder.registerCustomEditor(Pais.class, "pais", this.paisPropertyEditor);

        binder.registerCustomEditor(Role.class, "roles", this.rolePropertyEditor);
    }

    @GetMapping("/form")
    public String form(Model model) { // El objeto se inicializa y pasa al formulario de manera automatica o se puede hacer manual con model.add...
        var usuario = new Usuario();
        usuario.setNombre("Erick");
        usuario.setApellido("Diaz");
        usuario.setIdentificador("123.232K");
        usuario.setHabilitar(true);
        usuario.setPais(new Pais(3, "EC", "Ecuador"));
        usuario.setRoles(Arrays.asList(new Role(1, "Administrador", "ROL_ADMIN")));
        usuario.setValorSecreto("Algo secreto"); // Este campo se va a usar con el atributo hidden en las etiquetas de los archivos html sirve como @sessionAttribute

        model.addAttribute("user", usuario);
        model.addAttribute("titulo", "Formulario de Usuario");
        return "form";
    }

    // Se extraen los valores a traves del protocolo http request
    @PostMapping("/form")
    public String procesar(@Valid @ModelAttribute(name = "user") Usuario usuario, BindingResult result, Model model) { // En caso de errores en la validacion se usa binding, debe de estar siempre despues del objeto que se valida
        // ModdelAttribute se usa para definir con que nombre se va a pasar el objeto a la vista

        if (result.hasErrors()) {
            model.addAttribute("titulo", "Resultado Form");
            return "form";
        }

//        Se mappea de manera automatica al tener el mismo nombre de los campos en el html, es necesario tener setter en la entidad
//        model.addAttribute("usuario", usuario); // El Pojo usuario se pasa al formulario de manera automatica o manual
        return "redirect:/ver"; // Al hacer una nueva peticion los datos ya no quedan guardados
    }

//    Este metodo es para que cuando se cargue neuvamente el formulario los datos no se queden guardando y evitando duplicados 
    @GetMapping("/ver")
    public String ver(@SessionAttribute(name = "user", required = false) Usuario usuario, Model model, SessionStatus status) {
//        El usuario se pasa a la vista de manera automatica como ya se a visto
        if (usuario == null) {
            return "redirect:/form";
        }
        model.addAttribute("titulo", "Resultado Form");
        status.setComplete(); // Limpia los datos usados en sessionAttributes
        return "resultado";
    }

    @ModelAttribute("paises") // Este metodo sera tomado por todo los metodos handler para ser usado en la vista, paises sera el nombre para acceder
    public List<String> paises() {
        return Arrays.asList("Mexico", "Chile", "Ecuador", "Colombia", "Venezuela");
    }

    @ModelAttribute("paisesMap")
    public Map<String, String> paisesMap() {
        var paises = new HashMap<String, String>();
        paises.put("EC", "Ecuador");
        paises.put("CO", "Colombia");
        paises.put("CL", "Chile");
        paises.put("VE", "Venezuela");
        paises.put("MX", "Mexico");
        return paises;
    }

    @ModelAttribute("listaPaises")
    public List<Pais> listaPaises() {
        return this.paisService.listar();
    }

    @ModelAttribute("listaRolesString")
    public List<String> listaRolesString() {
        var roles = new ArrayList<String>();
        roles.add("ROL_ADMIN");
        roles.add("ROL_USER");
        roles.add("ROL_MODERATOR");
        return roles;
    }

    @ModelAttribute("listaRolesMap")
    public Map<String, String> listaRolesMap() {
        var roles = new HashMap<String, String>();
        roles.put("ROL_ADMIN", "Administrador");
        roles.put("ROL_USER", "Usuario");
        roles.put("ROL_MODERATOR", "Moderador");
        return roles;
    }

    @ModelAttribute("listaRoles")
    public List<Role> listaRoles() {
        return this.roleService.listar();
    }

    @ModelAttribute("generos")
    private List<String> listaGeneros() {
        return Arrays.asList("Hombre", "Mujer");
    }

}
