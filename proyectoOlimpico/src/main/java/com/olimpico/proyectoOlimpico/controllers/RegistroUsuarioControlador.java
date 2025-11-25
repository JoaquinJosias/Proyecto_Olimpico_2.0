package com.olimpico.proyectoOlimpico.controllers;

import com.olimpico.proyectoOlimpico.DTO.UsuarioRegistroDTO;
import com.olimpico.proyectoOlimpico.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

    private UsuarioService usuarioService;

    public RegistroUsuarioControlador(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @ModelAttribute("usuario")
    public UsuarioRegistroDTO retornarNuevoUsuarioRegistroDTO() {
        return new UsuarioRegistroDTO();
    }

    @GetMapping
    public String mostrarFormularioDeRegistro() {
        return "registro";
    }

    @PostMapping
    public String registrarUsuarioCuenta(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO,
                                        RedirectAttributes redirectAttributes) {
        usuarioService.guardarUsuario(registroDTO);
        return "redirect:/registro?exito";
    }
}
