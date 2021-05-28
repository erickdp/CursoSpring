package com.example.demo.domain;

import com.example.demo.validation.IdentificadorRegex;
import com.example.demo.validation.Requerido;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Erick Diaz
 */
public class Usuario {

    @IdentificadorRegex
    private String identificador;

    private String nombre;

    @Requerido
    private String apellido;

    @NotEmpty // Sea distinto de null y que tenga longitud mayor a 0
    @Size(min = 3, max = 8) // Size solo es para String
    private String username;

    @NotEmpty
    private String password;

    @Requerido
    @Email(message = "Correo con formato invalido")
    private String email;

    @NotNull // Not null es para objetos si fuera por ejemplo int seria con min 
    @Min(5)
    @Max(5000)
    private Integer cuenta;

    @NotNull
    @Future
    private Date fechaNacimiento;

    @NotNull
    private Pais pais;

    @NotNull
    private List<Role> roles;

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Integer getCuenta() {
        return cuenta;
    }

    public void setCuenta(Integer cuenta) {
        this.cuenta = cuenta;
    }

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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
