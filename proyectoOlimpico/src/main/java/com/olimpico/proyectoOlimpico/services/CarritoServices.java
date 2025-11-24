package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.model.Carrito;
import com.olimpico.proyectoOlimpico.repo.CarritoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoServices {

    private final CarritoRepository carritoRepository;

    public CarritoServices(CarritoRepository carritoRepository)
    {
        this.carritoRepository = carritoRepository;
    }

    //

    public List<Carrito> getAllCarritos(){
        return  carritoRepository.findAll();
    }

    public  Carrito getCarritoById(String id)
    {
        return  carritoRepository.findById(id).orElse(null);
    }

    public  Carrito saveCarrito(Carrito carrito)
    {
        return  carritoRepository.save(carrito);
    }

    public  void deleteCarrito(String id)
    {
        carritoRepository.deleteById(id);
    }
}
