package com.olimpico.proyectoOlimpico.repo;

import com.olimpico.proyectoOlimpico.model.Cotizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CotizacionRepository  extends JpaRepository<Cotizacion, Long> {
}
