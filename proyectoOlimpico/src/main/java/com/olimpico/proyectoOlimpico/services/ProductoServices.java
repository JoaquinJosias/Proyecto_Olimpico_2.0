package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.model.Producto;
import com.olimpico.proyectoOlimpico.repo.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServices {
    private final ProductoRepository productoRepository;


    public ProductoServices(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    //

    public List<Producto> getAllProducto()
    {
        return productoRepository.findAll();
    }

    //

    public Producto getByIdProducto(String id)
    {
        return productoRepository.findById(id).orElse(null);
    }

    //

    public Producto saveProducto(Producto producto)
    {
        return productoRepository.save(producto);
    }

    //

    public void deleteProducto(String id)
    {
        productoRepository.deleteById(id);
    }
}
