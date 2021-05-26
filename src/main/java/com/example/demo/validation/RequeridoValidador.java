package com.example.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

/**
 *
 * @author Erick Diaz
 */
public class RequeridoValidador implements ConstraintValidator<Requerido, String> {

    @Override
    public boolean isValid(String t, ConstraintValidatorContext cvc) {
        return !(t == null || !StringUtils.hasText(t)); // hasText valida que no tenga espacios en blanco y no este vacio
    }
    
}
