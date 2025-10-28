package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.model.Carrito;
import com.olimpico.proyectoOlimpico.model.Comprobante;
import com.olimpico.proyectoOlimpico.repo.CarritoRepository;
import com.olimpico.proyectoOlimpico.repo.ComprobanteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComprobanteServices {
    private final ComprobanteRepository comprobanteRepository;

    public ComprobanteServices(ComprobanteRepository comprobanteRepository)
    {
        this.comprobanteRepository = comprobanteRepository;
    }

    //

    public List<Comprobante> getAllComprobante(){
        return  comprobanteRepository.findAll();
    }

    public Comprobante getComprobanteById(String id)
    {
        return  comprobanteRepository.findById(id).orElse(null);
    }

    public  Comprobante saveComprobante(Comprobante comprobante)
    {
        return  comprobanteRepository.save(comprobante);
    }

    public  void deleteCarrito(String id)
    {
        comprobanteRepository.deleteById(id);
    }
}
