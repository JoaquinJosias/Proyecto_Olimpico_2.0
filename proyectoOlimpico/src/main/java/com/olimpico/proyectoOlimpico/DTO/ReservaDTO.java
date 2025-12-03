package com.olimpico.proyectoOlimpico.DTO;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ReservaDTO {
    private String nombre;

    private LocalDate fecha_reserva;

    private LocalTime hora_reserva;

    private int personas;
}
