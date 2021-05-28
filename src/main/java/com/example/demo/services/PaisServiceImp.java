package com.example.demo.services;

import com.example.demo.domain.Pais;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Erick Diaz
 */
@Service // Lo registramos como un contenedor de spring
public class PaisServiceImp implements PaisService {

    private List<Pais> lista;

    public PaisServiceImp() {
        this.lista = Arrays.asList(
                new Pais(1, "ME", "Mexico"),
                new Pais(2, "CL", "Chile"),
                new Pais(3, "EC", "Ecuador"),
                new Pais(4, "CO", "Colombia"),
                new Pais(5, "VE", "Venezuela"));
    }

    @Override
    public List<Pais> listar() {
        return this.lista;
    }

    @Override
    public Pais obtenerPorId(Integer id) {
        for (Pais pais : lista) {
            if (pais.getId() == id) {
                return pais;
            }
        }
        return null;
    }

}
