package com.olimpico.proyectoOlimpico.model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


@Entity
@Data
@Table(name = "Empleado")
public class Empleado {
    @Id
    @Column(name = "id_empleado")
    private String id_empleado;
    private String nombre_empleado;
    private String apellido_empleado;
    private String tipo_documento;
    private String numero_documento;
    private String telefono;
    private String email;
    private String direccion;
    private LocalDate fecha_contratacion;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_cargo", referencedColumnName = "id_cargo")
    private Cargo cargo;

    @OneToOne(mappedBy = "empleado", cascade = CascadeType.ALL)
    private Usuario usuario;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL)
    private List<Inventario> inventarios;
}
