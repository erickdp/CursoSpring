package com.example.demo.editors;

import com.example.demo.services.PaisService;
import java.beans.PropertyEditorSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Erick Diaz
 */
@Component // Service y component no cambian su funcionalidad da una descripcion conceptual
public class PaisPropertyEditor extends PropertyEditorSupport {

    @Autowired
    private PaisService paisService;

    @Override
    public void setAsText(String idString) throws IllegalArgumentException {
        try {
            this.setValue(this.paisService.obtenerPorId(Integer.parseInt(idString)));
        } catch (NumberFormatException e) {
            this.setValue(null);
        }
    }

}
