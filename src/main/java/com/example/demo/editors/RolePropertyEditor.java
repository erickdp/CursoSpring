package com.example.demo.editors;

import com.example.demo.services.RoleService;
import java.beans.PropertyEditorSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Erick Diaz
 */
@Component
public class RolePropertyEditor extends PropertyEditorSupport {
    
    @Autowired
    private RoleService roleService;
    
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            this.setValue(this.roleService.buscarPorId(Integer.parseInt(text)));
        } catch (NumberFormatException e) {
            this.setValue(this);
        }
    }
    
}
