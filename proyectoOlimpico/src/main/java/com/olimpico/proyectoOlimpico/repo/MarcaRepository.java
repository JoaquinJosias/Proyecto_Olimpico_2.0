package com.olimpico.proyectoOlimpico.repo;

import com.olimpico.proyectoOlimpico.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, String> {
}
