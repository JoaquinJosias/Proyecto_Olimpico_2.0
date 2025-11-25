package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.DTO.ProductoDTO;
import com.olimpico.proyectoOlimpico.model.Producto;

public interface ProductoService {

    public Producto guardarProducto(ProductoDTO productoDTO);
}
