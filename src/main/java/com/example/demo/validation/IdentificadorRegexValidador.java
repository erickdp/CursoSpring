package com.example.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author Erick Diaz
 */
public class IdentificadorRegexValidador implements ConstraintValidator<IdentificadorRegex, String> { // Defino el atributo a validar y el tipo, solo sirve para uno

    @Override
    public boolean isValid(String t, ConstraintValidatorContext cvc) {
        return t.matches("[0-9]{2}[.,][\\d]{3}[.,][\\d]{3}[-][A-Z]{1}");
    }

}
