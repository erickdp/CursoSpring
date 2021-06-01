package com.example.demo.domain;

/**
 *
 * @author Erick Diaz
 */
public class Role {

    private Integer id;
    private String nombre;
    private String rol;

    public Role() {
    }

    public Role(Integer id, String nombre, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    
//    Este metodo se implementa para compara los objetos pasados por la lista y que se comparen por valor de id con respecto a la lista pasada
    @Override
    public boolean equals(Object obj) {
        
        if(this == obj) {
            return true;
        }
        
        if(!(obj instanceof Role)) {
            return false;
        }
        
        Role rol = (Role) obj;
        return this.id != null && rol.getId().equals(this.id);
    }
}
