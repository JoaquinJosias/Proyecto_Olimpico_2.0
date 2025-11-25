// java
package com.olimpico.proyectoOlimpico.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.servlet.http.HttpSession;
import java.util.Optional;
import com.olimpico.proyectoOlimpico.model.Usuario;
import com.olimpico.proyectoOlimpico.repo.UsuarioRepository;

@Controller
public class LoginController {

    private final UsuarioRepository usuarioRepository;

    public LoginController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes redirectAttributes) {

        Optional<Usuario> opt = usuarioRepository.findByEmail(email);
        if (opt.isPresent()) {
            Usuario usuario = opt.get();
            if (usuario.getPassword() != null && usuario.getPassword().equals(password)) {
                session.setAttribute("usuarioId", usuario.getId_usuario());
                session.setAttribute("usuarioNombre", usuario.getNombre());
                boolean esAdmin = usuario.getId_usuario() != null && usuario.getId_usuario().longValue() == 1L;
                session.setAttribute("usuarioEsAdmin", esAdmin);
                return "redirect:/";
            }
        }

        redirectAttributes.addAttribute("error", "true");
        return "redirect:/login";
    }
}
