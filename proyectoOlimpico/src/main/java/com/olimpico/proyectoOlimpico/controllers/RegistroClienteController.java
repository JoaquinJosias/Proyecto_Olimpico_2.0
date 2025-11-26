package com.olimpico.proyectoOlimpico.controllers;

import com.olimpico.proyectoOlimpico.DTO.ClienteDTO;
import com.olimpico.proyectoOlimpico.model.Cliente;
import com.olimpico.proyectoOlimpico.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cliente")
public class RegistroClienteController {

    private final ClienteService clienteService;

    public RegistroClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/{usuarioId}/perfil")
    public ResponseEntity<Cliente> savePerfil(
            @PathVariable Long usuarioId,
            @Valid @RequestBody ClienteDTO dto) {
        Cliente saved = clienteService.saveOrUpdateProfileByUsuarioId(usuarioId, dto);
        return ResponseEntity.ok(saved);
    }
}
