package com.olimpico.proyectoOlimpico.repo;

import com.olimpico.proyectoOlimpico.model.Pago_Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoProveedorRepository extends JpaRepository<Pago_Proveedor, String> {
}
