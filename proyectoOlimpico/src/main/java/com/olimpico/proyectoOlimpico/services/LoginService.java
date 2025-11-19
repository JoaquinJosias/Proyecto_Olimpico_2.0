package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.controllers.DTO.LoginDTO;
import com.olimpico.proyectoOlimpico.model.Usuario;
import com.olimpico.proyectoOlimpico.repo.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UsuarioRepository usuarioRepository;

    public LoginService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario login(LoginDTO dto) throws Exception {

        Usuario usuario = usuarioRepository.findByUsername(dto.getUsername());

        if (usuario == null) {
            throw new Exception("El usuario no existe");
        }

        if (!usuario.getPassword_hash().equals(dto.getPassword())) {
            throw new Exception("Contraseña incorrecta");
        }

        return usuario;
    }
}
