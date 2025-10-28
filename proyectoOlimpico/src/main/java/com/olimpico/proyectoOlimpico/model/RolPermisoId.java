package com.olimpico.proyectoOlimpico.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class RolPermisoId implements Serializable {
    private String idRol;
    private String idPermiso;
}
