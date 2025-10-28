package com.olimpico.proyectoOlimpico.repo;

import com.olimpico.proyectoOlimpico.model.DetCarrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetCarritoRepository  extends JpaRepository<DetCarrito, String> {
}
