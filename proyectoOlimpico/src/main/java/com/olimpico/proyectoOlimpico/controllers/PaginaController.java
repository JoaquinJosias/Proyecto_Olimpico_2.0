package com.olimpico.proyectoOlimpico.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class PaginaController {
    @GetMapping("/")
    public String inicio() {
        return "index"; // templates/index.html
    }

    @GetMapping("/carta")
    public String carta() {
        return "carta"; // templates/carta.html
    }

    @GetMapping("/promociones")
    public String promociones() {
        return "promociones"; // templates/promociones.html
    }

    @GetMapping("/reserva")
    public String reserva() {
        return "reserva"; // templates/reserva.html
    }

    @GetMapping("/sobre_nosotros")
    public String sobreNosotros() {
        return "sobre_nosotros"; // templates/sobre_nosotros.html
    }

    @GetMapping("/ubicacion")
    public String ubicacion() {
        return "ubicacion"; // templates/ubicacion.html
    }

}
