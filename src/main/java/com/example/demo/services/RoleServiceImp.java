package com.example.demo.services;

import com.example.demo.domain.Role;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Erick Diaz
 */
@Service
public class RoleServiceImp implements RoleService {
    
    private List<Role> lista;

    public RoleServiceImp() {
        lista = new ArrayList<>();
        
        lista.add(new Role(1, "Administrador", "ROL_ADMIN"));
        lista.add(new Role(2, "Usuario", "ROL_USER"));
        lista.add(new Role(3, "Moderador", "ROL_MODERATOR"));
    }
    
    @Override
    public List<Role> listar() {
        return this.lista;
    }

    @Override
    public Role buscarPorId(Integer id) {
        for (Role role : lista) {
            if(role.getId() == id) {
                return role;
            }
        }
        return null;
    }
    
}
