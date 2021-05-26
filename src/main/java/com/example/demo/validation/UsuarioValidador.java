package com.example.demo.validation;

import com.example.demo.domain.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Erick Diaz
 */
@Component // Registro como un contenedor de spring
public class UsuarioValidador implements Validator {

    @Override
    public boolean supports(Class<?> type) { // Aqui se define que clase entity o pojo se valida
        return Usuario.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        var usuario = (Usuario) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "requerido.usuario.nombre"); // Primera forma

        /* Segunda forma
        if(usuario.getNombre().isEmpty()) {
            errors.rejectValue("nombre", "NotEmpty.user.nombre");
        }
         */
        
        if (!usuario.getIdentificador().matches("[0-9]{2}[.,][\\d]{3}[.,][\\d]{3}[-][A-Z]{1}")) {
            errors.rejectValue("identificador", "pattern.usuario.identificador");
        }

    }

}
