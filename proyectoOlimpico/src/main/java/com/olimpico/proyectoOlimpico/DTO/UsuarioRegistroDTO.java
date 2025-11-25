package com.olimpico.proyectoOlimpico.DTO;

import lombok.Data;

@Data
public class UsuarioRegistroDTO {
    private String nombre;
    private String apellido;
    private String password;
    private String email;
}
