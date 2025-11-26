package com.olimpico.proyectoOlimpico.DTO;

import lombok.Data;

@Data
public class ClienteDTO {
    private Long usuarioId;
    private String dni;
    private String telefono;
    private String direccion;
}
