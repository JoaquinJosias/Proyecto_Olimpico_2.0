package com.olimpico.proyectoOlimpico.controllers.DTO;

import lombok.Data;

@Data
public class RegistroDTO {
    private String nombreCompleto;
    private String username;
    private String email;
    private String password;
    private String dni;
    private String telefono;
    private String direccion;
}
