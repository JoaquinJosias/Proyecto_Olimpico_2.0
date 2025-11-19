package com.olimpico.proyectoOlimpico.controllers;


import com.olimpico.proyectoOlimpico.controllers.DTO.LoginDTO;
import com.olimpico.proyectoOlimpico.controllers.DTO.RegistroDTO;
import com.olimpico.proyectoOlimpico.services.LoginService;
import com.olimpico.proyectoOlimpico.services.RegistroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final RegistroService registroService;
    private final LoginService loginService;

    // ---------- REGISTRO ----------
    @GetMapping("/registro")
    public String mostrarRegistro(Model model) {
        model.addAttribute("registroDTO", new RegistroDTO());
        return "registro"; // tu vista registro.html
    }

    @PostMapping("/registro")
    public String registro(@ModelAttribute RegistroDTO dto, Model model) {
        try {
            registroService.registrarCliente(dto);
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "registro";
        }
    }

    // ---------- LOGIN ----------
    @GetMapping("/login")
    public String mostrarLogin(Model model) {
        model.addAttribute("loginDTO", new LoginDTO());
        return "login"; // tu login.html
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDTO dto, Model model) {
        try {
            loginService.login(dto);
            return "redirect:/"; // página principal
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "login"; // vuelve con error
        }
    }
}
