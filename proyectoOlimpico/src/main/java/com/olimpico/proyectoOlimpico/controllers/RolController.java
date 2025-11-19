package com.olimpico.proyectoOlimpico.controllers;

import com.olimpico.proyectoOlimpico.model.Rol;
import com.olimpico.proyectoOlimpico.services.RolServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RolController {
    @Autowired
    private final RolServices rolServices;
    public RolController(RolServices rolServices) {
        this.rolServices = rolServices;
    }

    @GetMapping("/roles" )
    public List<Rol> getAllRoles() {
        return rolServices.getAllRoles();
    }

    @GetMapping("/roles/{id}" )
    public Rol getRolById(String id) {
        return rolServices.getByIdRol(id);
    }

    @PostMapping("/roles")
    public Rol createRol(Rol rol) {
        return rolServices.saveRol(rol);
    }

    @DeleteMapping("/roles/{id}" )
    public void deleteRol(String id) {
        rolServices.deleteRol(id);
    }
}
