package com.example.demo;

import com.example.demo.domain.ItemFactura;
import com.example.demo.domain.Producto;
import java.util.Arrays;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Erick Diaz
*/
@Configuration
public class AppConfig {
    
    @Bean("itemsFactura")
    private List<ItemFactura> registrarItems() {
        var producto1 = new Producto("Camara", 100);
        var producto2 = new Producto("Celular", 200);
        
        var itemFactura1 = new ItemFactura(producto1, 1);
        var itemFactura2 = new ItemFactura(producto2, 2);
        
        return Arrays.asList(itemFactura1, itemFactura2);
    }
    
}
