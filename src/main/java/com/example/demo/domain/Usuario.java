package com.example.demo.domain;

import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Erick Diaz
 */
public class Usuario {

    @NotEmpty // Sea distinto de null y que tenga longitud mayor a 0
    private String username;
    
    @NotEmpty
    private String password;
    
    @NotEmpty
    private String email;

    public String getUsername() {
        return username;
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
}
