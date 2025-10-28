package com.olimpico.proyectoOlimpico.repo;

import com.olimpico.proyectoOlimpico.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, String> {
}
