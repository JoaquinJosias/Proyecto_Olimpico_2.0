package com.olimpico.proyectoOlimpico.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "Inventario")
public class Inventario {
    @Id
    @Column(name = "id_inventario")
    private String id_inventario;

    private LocalDate fecha_inventario;

    @ManyToOne
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    private Empleado empleado;


    @OneToMany(mappedBy = "inventario", cascade = CascadeType.ALL)
    private  List<DetInveProd> detallesProducto;

}
