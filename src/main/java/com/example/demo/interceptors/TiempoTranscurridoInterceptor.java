package com.example.demo.interceptors;

import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Erick Diaz
 */
@Component("tiempoTranscurridoInterceptor")
public class TiempoTranscurridoInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(TiempoTranscurridoInterceptor.class);

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long tiempoFin = System.currentTimeMillis();
        long tiempoInicio = (long) request.getAttribute("tiempoInicio");
        long tiempoTranscurrido = tiempoFin - tiempoInicio;

        if (handler instanceof HandlerMethod && modelAndView != null) { // Los recursos de la app como hojas de estilo, js tambien son rutas y se interceptan pero estan en otro contexto no son controladores pero se interceptan
            modelAndView.addObject("tiempoTranscurrido", tiempoTranscurrido);
        }

        logger.info("Tiempo transcurrido: ".concat(String.valueOf(tiempoFin)).concat(" ms"));
        logger.info("TiempoTranscurridoInterceptor: posHandle() saliendo...");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        if (handler instanceof HandlerMethod) { 
            HandlerMethod metodo = (HandlerMethod) handler;
            logger.info("es un método controlador: ".concat(metodo.getMethod().getName()));
        }
        
        logger.info("TiempoTranscurridoInterceptor: preHandle() entrado...");

        long tiempoInicio = System.currentTimeMillis();
        request.setAttribute("tiempoInicio", tiempoInicio);

        Random random = new Random();
        Integer demora = random.nextInt(500);
        Thread.sleep(demora);

        return true;
    }

}
