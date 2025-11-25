package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.DTO.ProductoDTO;
import com.olimpico.proyectoOlimpico.model.Producto;
import com.olimpico.proyectoOlimpico.repo.ProductoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImp implements  ProductoService{

    private ProductoRepository productoRepository;

    public ProductoServiceImp(ProductoRepository productoRepository) {
        super();
        this.productoRepository = productoRepository;
    }



    @Override
    public Producto guardarProducto(ProductoDTO productoDTO) {
        Producto producto = new Producto(
                productoDTO.getStockActual(),
                productoDTO.getNombreProducto(),
                productoDTO.getPrecioVenta(),
                productoDTO.getCostoUnitario(),
                productoDTO.getEstado()
                );
        return productoRepository.save(producto);
    }
}
