package com.olimpico.proyectoOlimpico.repo;

import com.olimpico.proyectoOlimpico.model.RolPermiso;
import com.olimpico.proyectoOlimpico.model.RolPermisoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolPermisoRepository extends JpaRepository<RolPermiso, RolPermisoId> {
}
