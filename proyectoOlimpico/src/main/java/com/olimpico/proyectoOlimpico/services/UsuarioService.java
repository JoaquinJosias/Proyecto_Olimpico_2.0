package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.DTO.UsuarioRegistroDTO;
import com.olimpico.proyectoOlimpico.model.Usuario;

public interface UsuarioService {

    public Usuario guardarUsuario(UsuarioRegistroDTO usuarioRegistroDTO);
}
