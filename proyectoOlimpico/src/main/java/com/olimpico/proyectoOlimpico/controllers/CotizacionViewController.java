package com.olimpico.proyectoOlimpico.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CotizacionViewController {

    @GetMapping("/cotizacion")
    public String mostrarCotizacion() {
        // Devuelve la plantilla located en src/main/resources/templates/cotizacion.html
        return "cotizacion";
    }
}
