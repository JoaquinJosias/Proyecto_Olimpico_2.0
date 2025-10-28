package com.olimpico.proyectoOlimpico.repo;

import com.olimpico.proyectoOlimpico.model.DetCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetCompraRepository extends JpaRepository<DetCompra, String> {
}
