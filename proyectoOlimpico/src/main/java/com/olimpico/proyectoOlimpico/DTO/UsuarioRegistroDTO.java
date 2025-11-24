package com.olimpico.proyectoOlimpico.DTO;

import lombok.Data;

@Data
public class UsuarioRegistroDTO {

    private String id_usuario;

    private String username;

    private String password_hash;

    private String email;
}
