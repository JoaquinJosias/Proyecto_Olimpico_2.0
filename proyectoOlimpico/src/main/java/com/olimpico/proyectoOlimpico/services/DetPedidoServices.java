package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.model.DetPedido;
import com.olimpico.proyectoOlimpico.repo.DetPedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetPedidoServices {
    private final DetPedidoRepository detPedidoRepository;


    public DetPedidoServices(DetPedidoRepository detPedidoRepository) {
        this.detPedidoRepository = detPedidoRepository;
    }

    //

    public List<DetPedido> getAllDetPedido()
    {
        return  detPedidoRepository.findAll();
    }

    //

    public DetPedido getDetPedidoById(String id)
    {
        return  detPedidoRepository.findById(id).orElse(null);
    }

    //

    public DetPedido saveDetPedido(DetPedido detPedido)
    {
        return  detPedidoRepository.save(detPedido);
    }

    //

    public void  deleteDetPedido(String id)
    {
        detPedidoRepository.deleteById(id);
    }
}
