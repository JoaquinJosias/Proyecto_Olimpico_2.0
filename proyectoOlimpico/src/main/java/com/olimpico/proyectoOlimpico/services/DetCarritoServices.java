package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.model.Comprobante;
import com.olimpico.proyectoOlimpico.model.DetCarrito;
import com.olimpico.proyectoOlimpico.repo.ComprobanteRepository;
import com.olimpico.proyectoOlimpico.repo.DetCarritoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetCarritoServices {
    private final DetCarritoRepository detCarritoRepository;

    public DetCarritoServices(DetCarritoRepository detCarritoRepository)
    {
        this.detCarritoRepository = detCarritoRepository;
    }

    //

    public List<DetCarrito> getAllDetallesCarrito(){
        return  detCarritoRepository.findAll();
    }

    public DetCarrito getDetCarritoById(String id)
    {
        return  detCarritoRepository.findById(id).orElse(null);
    }

    public DetCarrito saveDetCarrito(DetCarrito detCarrito)
    {
        return  detCarritoRepository.save(detCarrito);
    }

    public  void deleteDetCarrito(String id)
    {
        detCarritoRepository.deleteById(id);
    }
}
