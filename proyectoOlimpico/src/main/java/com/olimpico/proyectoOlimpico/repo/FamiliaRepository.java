package com.olimpico.proyectoOlimpico.repo;

import com.olimpico.proyectoOlimpico.model.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia, String> {
}
