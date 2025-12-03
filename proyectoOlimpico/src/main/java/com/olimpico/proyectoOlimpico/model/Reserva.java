package com.olimpico.proyectoOlimpico.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@Entity
@Table(name = "Reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Long id_reserva;

    private String nombre;

    private LocalDate fecha_reserva;

    private LocalTime hora_reserva;

    private int personas;

    public Reserva(String nombre, LocalDate fecha_reserva, LocalTime hora_reserva, int personas) {
        this.nombre = nombre;
        this.fecha_reserva = fecha_reserva;
        this.hora_reserva = hora_reserva;
        this.personas = personas;
    }
}


