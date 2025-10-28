package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.model.Usuario;
import com.olimpico.proyectoOlimpico.repo.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServices {
    private final UsuarioRepository usuarioRepository;


    public UsuarioServices(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //

    public List<Usuario> getAllUsuario()
    {
        return usuarioRepository.findAll();
    }

    //

    public Usuario getByIdUsuario(String id)
    {
        return usuarioRepository.findById(id).orElse(null);
    }

    //

    public Usuario saveUsuario(Usuario usuario)
    {
        return usuarioRepository.save(usuario);
    }

    //

    public void deleteUsuario(String id)
    {
        usuarioRepository.deleteById(id);
    }
}
