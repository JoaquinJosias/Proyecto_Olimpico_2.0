package com.olimpico.proyectoOlimpico.repo;

import com.olimpico.proyectoOlimpico.model.DetPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetPedidoRepository extends JpaRepository<DetPedido, String> {
}
