package com.olimpico.proyectoOlimpico.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Rol")
public class Rol {
    @Id
    @Column(name = "id_rol")
    private String id_rol;

    private String nombre;

    public Rol(String nombre) {
        this.nombre = nombre;
    }
}
