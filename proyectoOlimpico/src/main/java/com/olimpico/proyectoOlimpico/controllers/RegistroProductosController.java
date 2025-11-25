package com.olimpico.proyectoOlimpico.controllers;

import com.olimpico.proyectoOlimpico.DTO.ProductoDTO;
import com.olimpico.proyectoOlimpico.services.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/producto")
public class RegistroProductosController {

    private ProductoService   productoService;

    public RegistroProductosController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @ModelAttribute("producto")
    public ProductoDTO retornarNuevoProducto() {
        return new ProductoDTO();
    }

    @GetMapping
    public String mostrarFormularioDeRegistroProductos() {
        return "producto";
    }

    @PostMapping
    public String registrarProductoCuenta(@ModelAttribute("producto") ProductoDTO productoDTO,
                                          RedirectAttributes redirectAttributes) {
        productoService.guardarProducto(productoDTO);
        redirectAttributes.addAttribute("exito", "true");
        return "redirect:/producto?exito";
    }
}
