package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.DTO.ReservaDTO;
import com.olimpico.proyectoOlimpico.model.Reserva;
import com.olimpico.proyectoOlimpico.repo.ReservaRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImp implements ReservaService{

    private ReservaRepository reservaRepository;

    public ReservaServiceImp(ReservaRepository reservaRepository) {
        super();
        this.reservaRepository = reservaRepository;
    }


    @Override
    public Reserva guardarReserva(ReservaDTO reservaDTO) {
        Reserva reserva = new Reserva(
                reservaDTO.getNombre(),
                reservaDTO.getFecha_reserva(),
                reservaDTO.getHora_reserva(),
                reservaDTO.getPersonas()
        );
        return reservaRepository.save(reserva);
    }
}
