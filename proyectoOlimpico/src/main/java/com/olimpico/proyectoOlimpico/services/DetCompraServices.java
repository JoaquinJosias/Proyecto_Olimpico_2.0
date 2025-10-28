package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.model.DetCompra;
import com.olimpico.proyectoOlimpico.repo.DetCarritoRepository;
import com.olimpico.proyectoOlimpico.repo.DetCompraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetCompraServices {
    private final DetCompraRepository detCompraRepository;


    public DetCompraServices(DetCompraRepository detCompraRepository) {
        this.detCompraRepository = detCompraRepository;
    }

    //

    public List<DetCompra> getAllDetCompras()
    {
        return detCompraRepository.findAll();
    }

    //

    public  DetCompra getDetCompraById(String id)
    {
        return detCompraRepository.findById(id).orElse(null);
    }

    //

    public  DetCompra saveDetCompra (DetCompra detCompra)
    {
        return  detCompraRepository.save(detCompra);
    }

    //

    public void deleteDetCompra(String id)
    {
        detCompraRepository.deleteById(id);
    }
}
