package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.DTO.ReservaDTO;
import com.olimpico.proyectoOlimpico.model.Reserva;

public interface ReservaService {

    public Reserva guardarReserva(ReservaDTO reservaDTO);
}
