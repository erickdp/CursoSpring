package com.example.demo.services;

import com.example.demo.domain.Pais;
import java.util.List;

/**
 *
 * @author Erick Diaz
 */
public interface PaisService {

    List<Pais> listar();

    Pais obtenerPorId(Integer id);
}
