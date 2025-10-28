package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.model.Pedido;
import com.olimpico.proyectoOlimpico.repo.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServices {
    private final PedidoRepository pedidoRepository;

    public PedidoServices(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    //

    public List<Pedido> getAllPedidos()
    {
        return pedidoRepository.findAll();
    }

    //

    public Pedido getPedidoById(String id)
    {
        return pedidoRepository.findById(id).orElse(null);
    }

    //

    public Pedido savePedido(Pedido pedido)
    {
        return pedidoRepository.save(pedido);
    }

    //

    public void deletePedido(String id)
    {
        pedidoRepository.deleteById(id);
    }
}
