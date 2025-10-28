package com.olimpico.proyectoOlimpico.repo;

import com.olimpico.proyectoOlimpico.model.DetInveProd;
import com.olimpico.proyectoOlimpico.model.DetInveProdId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetInveProdRepository extends JpaRepository<DetInveProd, DetInveProdId> {
}
