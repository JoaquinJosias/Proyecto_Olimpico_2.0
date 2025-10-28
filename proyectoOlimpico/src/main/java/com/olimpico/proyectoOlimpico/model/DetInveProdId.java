package com.olimpico.proyectoOlimpico.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class DetInveProdId implements Serializable {
    private String idProducto;
    private String idInventario;
}
