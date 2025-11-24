package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.DTO.UsuarioRegistroDTO;
import com.olimpico.proyectoOlimpico.model.Rol;
import com.olimpico.proyectoOlimpico.model.Usuario;
import com.olimpico.proyectoOlimpico.repo.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;

@Service
public class UsuarioServicesImpl implements  UsuarioServices{

    private UsuarioRepository usuarioRepository;

    public UsuarioServicesImpl(UsuarioRepository usuarioRepository) {
        super();
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario guardar(UsuarioRegistroDTO registroDTO)
    {
        Usuario usuario = new Usuario(registroDTO.getUsername(),registroDTO.getEmail(),registroDTO.getPassword_hash(), Arrays.asList(new Rol("ROLE_USER")));
        return usuarioRepository.save(usuario);

    }
}
