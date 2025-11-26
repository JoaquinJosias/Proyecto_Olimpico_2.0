package com.olimpico.proyectoOlimpico.controllers;


import com.olimpico.proyectoOlimpico.DTO.ClienteDTO;
import com.olimpico.proyectoOlimpico.model.Cliente;
import com.olimpico.proyectoOlimpico.services.ClienteService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PerfilController {
    private static final Logger log = LoggerFactory.getLogger(PerfilController.class);
    private final ClienteService clienteService;

    public PerfilController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/perfil")
    public String verPerfil(HttpSession session, Model model, RedirectAttributes ra) {
        try {
            Object uid = session.getAttribute("usuarioId");
            if (uid == null) {
                ra.addFlashAttribute("error", "Debes iniciar sesión");
                return "redirect:/login";
            }
            Long usuarioId;
            if (uid instanceof Long) {
                usuarioId = (Long) uid;
            } else if (uid instanceof Integer) {
                usuarioId = ((Integer) uid).longValue();
            } else {
                usuarioId = Long.parseLong(uid.toString());
            }

            Cliente cliente = clienteService.findByUsuarioId(usuarioId);
            ClienteDTO dto = new ClienteDTO();
            if (cliente != null) {
                dto.setDni(cliente.getDni());
                dto.setTelefono(cliente.getTelefono());
                dto.setDireccion(cliente.getDireccion());
            }
            model.addAttribute("cliente", dto);
            return "cliente";
        } catch (Exception e) {
            log.error("Error en /perfil", e);
            model.addAttribute("errorMessage", "Error al cargar el perfil: " + e.getMessage());
            return "error";
        }
    }

    @PostMapping("/perfil")
    public String guardarPerfil(@Valid @ModelAttribute("cliente") ClienteDTO dto,
                                BindingResult bindingResult,
                                HttpSession session,
                                RedirectAttributes ra,
                                Model model) {
        try {
            Object uid = session.getAttribute("usuarioId");
            if (uid == null) {
                ra.addFlashAttribute("error", "Debes iniciar sesión");
                return "redirect:/login";
            }
            Long usuarioId;
            if (uid instanceof Long) {
                usuarioId = (Long) uid;
            } else if (uid instanceof Integer) {
                usuarioId = ((Integer) uid).longValue();
            } else {
                usuarioId = Long.parseLong(uid.toString());
            }

            if (bindingResult.hasErrors()) {
                return "cliente";
            }

            clienteService.saveOrUpdateProfileByUsuarioId(usuarioId, dto);
            ra.addFlashAttribute("exito", "Perfil guardado");
            return "redirect:/perfil";
        } catch (Exception e) {
            log.error("Error guardando perfil", e);
            model.addAttribute("errorMessage", "Error al guardar el perfil: " + e.getMessage());
            return "error";
        }
    }
}

