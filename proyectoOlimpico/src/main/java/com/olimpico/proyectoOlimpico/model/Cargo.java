package com.olimpico.proyectoOlimpico.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Cargo")
public class Cargo {
    @Id
    @Column(name = "id_cargo")
    private String id_cargo;

    private String nombre_cargo;

    private String estado;

    @OneToMany(mappedBy = "cargo", cascade = CascadeType.ALL)
    private List<Empleado> empleados;
}
