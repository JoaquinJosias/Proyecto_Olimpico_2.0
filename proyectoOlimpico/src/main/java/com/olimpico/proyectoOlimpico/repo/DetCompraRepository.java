package com.olimpico.proyectoOlimpico.repo;

import com.olimpico.proyectoOlimpico.model.FacturaCompra;
import com.olimpico.proyectoOlimpico.model.FacturaCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetCompraRepository extends JpaRepository<FacturaCompra, String> {
}
