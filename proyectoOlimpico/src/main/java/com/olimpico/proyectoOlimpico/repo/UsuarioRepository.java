package com.olimpico.proyectoOlimpico.repo;

import com.olimpico.proyectoOlimpico.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
}
