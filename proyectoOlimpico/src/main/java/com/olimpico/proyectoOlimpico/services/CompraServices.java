package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.model.Carrito;
import com.olimpico.proyectoOlimpico.model.Compra;
import com.olimpico.proyectoOlimpico.repo.CarritoRepository;
import com.olimpico.proyectoOlimpico.repo.CompraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraServices {
    private final CompraRepository compraRepository;

    public  CompraServices(CompraRepository compraRepository)
    {
        this.compraRepository = compraRepository;
    }

    //

    public List<Compra> getAllCompras(){
        return  compraRepository.findAll();
    }

    public  Compra getCompraById(String id)
    {
        return  compraRepository.findById(id).orElse(null);
    }

    public  Compra saveCompra(Compra compra)
    {
        return  compraRepository.save(compra);
    }

    public  void deleteCompra(String id)
    {
        compraRepository.deleteById(id);
    }
}
