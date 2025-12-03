package com.olimpico.proyectoOlimpico.controllers;

import com.olimpico.proyectoOlimpico.DTO.ReservaDTO;
import com.olimpico.proyectoOlimpico.services.ReservaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/reserva")
public class RegistroReservaController {

    private ReservaService reservaService;

    public RegistroReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @ModelAttribute("reserva")
    public ReservaDTO retornarNuevaReserva() {
        return new ReservaDTO();
    }

    @GetMapping
    public String mostrarFormularioDeRegistroReserva() {
        return "reserva";
    }

    @PostMapping
    public String registrarReserva(@ModelAttribute("reserva") ReservaDTO reservaDTO, RedirectAttributes redirectAttributes) {
        reservaService.guardarReserva(reservaDTO);
        redirectAttributes.addAttribute("exito", "true");
        return "redirect:/reserva?exito";
    }
}
