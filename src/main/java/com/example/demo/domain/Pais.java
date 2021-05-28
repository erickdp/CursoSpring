package com.example.demo.domain;

import javax.validation.constraints.NotNull;

/**
 *
 * @author Erick Diaz
 */
public class Pais {

    @NotNull // Debo validar que no sea nulo
    private Integer id;
    
    private String codigo;
    private String nombre;

    public Pais(Integer id, String codigo, String nombre) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Pais() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}