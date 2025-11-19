package com.olimpico.proyectoOlimpico.controllers;

import com.olimpico.proyectoOlimpico.model.Usuario;
import com.olimpico.proyectoOlimpico.services.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private final UsuarioServices usuarioServices;

    public UsuarioController(UsuarioServices usuarioServices) {
        this.usuarioServices = usuarioServices;
    }

    @GetMapping("/usuarios" )
    public List<Usuario> getUsuarios() {
        return usuarioServices.getAllUsuario();
    }

    @GetMapping("/usuarios/{id}")
    public Usuario getUsuarioById(String id) {
        return usuarioServices.getByIdUsuario(id);
    }

    @PostMapping("/usuarios")
    public Usuario createUsuario( Usuario usuario) {
        return usuarioServices.saveUsuario(usuario);
    }

    @DeleteMapping("/usuarios/{id}" )
    public void deleteUsuario(String id) {
        usuarioServices.deleteUsuario(id);
    }

}
