package com.olimpico.proyectoOlimpico.services;


import com.olimpico.proyectoOlimpico.model.UsuarioRol;
import com.olimpico.proyectoOlimpico.model.UsuarioRolId;
import com.olimpico.proyectoOlimpico.repo.UsuarioRolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioRolServices {
    private final UsuarioRolRepository usuarioRolRepository;

    public UsuarioRolServices(UsuarioRolRepository usuarioRolRepository) {
        this.usuarioRolRepository = usuarioRolRepository;
    }
    //
    public List<UsuarioRol> getAllUsuarioRol()
    {
        return usuarioRolRepository.findAll();
    }

    //

    public UsuarioRol getByIdUsuarioRol(UsuarioRolId id)
    {
        return usuarioRolRepository.findById(id).orElse(null);
    }

    //

    public UsuarioRol saveUsuarioRol(UsuarioRol usuarioRol)
    {
        return usuarioRolRepository.save(usuarioRol);
    }

    //

    public void deleteUsuarioRol(UsuarioRolId id)
    {
        usuarioRolRepository.deleteById(id );
    }
}
