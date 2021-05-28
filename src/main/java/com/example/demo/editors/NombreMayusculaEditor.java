package com.example.demo.editors;

import java.beans.PropertyEditorSupport;

/**
 *
 * @author Erick Diaz
 */
public class NombreMayusculaEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(text.toUpperCase().trim());
    }
}
