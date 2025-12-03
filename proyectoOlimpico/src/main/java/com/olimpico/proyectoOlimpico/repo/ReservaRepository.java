package com.olimpico.proyectoOlimpico.repo;


import com.olimpico.proyectoOlimpico.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, String> {
}
