package com.olimpico.proyectoOlimpico.repo;

import com.olimpico.proyectoOlimpico.model.UsuarioRol;
import com.olimpico.proyectoOlimpico.model.UsuarioRolId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, UsuarioRolId> {
}
