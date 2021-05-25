package com.example.demo.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *
 * @author Erick Diaz
 */
public class Usuario {
    
    private String identificador;

    private String nombre;

    @NotEmpty
    private String apellido;

    @NotEmpty // Sea distinto de null y que tenga longitud mayor a 0
    @Size(min = 3, max = 8) // Size solo es para String
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    @Email(message = "Correo con formato invalido")
    private String email;

    public String getUsername() {
        return username;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
