package com.olimpico.proyectoOlimpico.repo;

import com.olimpico.proyectoOlimpico.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, String> {
}
