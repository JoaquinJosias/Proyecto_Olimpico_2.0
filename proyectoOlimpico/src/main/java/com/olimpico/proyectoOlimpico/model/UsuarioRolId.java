package com.olimpico.proyectoOlimpico.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class UsuarioRolId implements Serializable {
    private String idUsuario;
    private String idRol;
}
