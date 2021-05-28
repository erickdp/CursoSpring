package com.example.demo.services;

import com.example.demo.domain.Role;
import java.util.List;

/**
 *
 * @author Erick Diaz
 */
public interface RoleService {

    List<Role> listar();

    Role buscarPorId(Integer id);
}
