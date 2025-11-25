package com.olimpico.proyectoOlimpico.controllers;

import com.olimpico.proyectoOlimpico.DTO.ProductoDTO;
import com.olimpico.proyectoOlimpico.DTO.ProveedorDTO;
import com.olimpico.proyectoOlimpico.services.ProveedorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/proveedor")
public class RegistroProveedorController {

    private ProveedorService proveedorService;

    public RegistroProveedorController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @ModelAttribute("proveedor")
    public ProveedorDTO retornarNuevoProveedor() {
        return new ProveedorDTO();
    }

    @GetMapping
    public String mostrarFormularioDeRegistroProveedor() {
        return "proveedor";
    }

    @PostMapping
    public String registrarProveedorCuenta(@ModelAttribute("proveedor") ProveedorDTO proveedorDTO,
                                           RedirectAttributes redirectAttributes) {
        return "redirect:/proveedor?exito";
    }
}
