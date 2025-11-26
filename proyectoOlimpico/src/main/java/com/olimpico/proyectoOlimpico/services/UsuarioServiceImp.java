package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.DTO.UsuarioRegistroDTO;
import com.olimpico.proyectoOlimpico.model.Rol;
import com.olimpico.proyectoOlimpico.model.Usuario;
import com.olimpico.proyectoOlimpico.repo.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;

@Service
public class UsuarioServiceImp implements  UsuarioService{

    private UsuarioRepository usuarioRepository;


    public UsuarioServiceImp(UsuarioRepository usuarioRepository) {
        super();
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario guardarUsuario(UsuarioRegistroDTO usuarioRegistroDTO) {
        Usuario usuario = new Usuario(usuarioRegistroDTO.getNombre(),
                usuarioRegistroDTO.getApellido(),
                usuarioRegistroDTO.getEmail(),
                usuarioRegistroDTO.getPassword(),
                Arrays.asList(new Rol("ROL_USER"))
        );
        return usuarioRepository.save(usuario);
    }
}
