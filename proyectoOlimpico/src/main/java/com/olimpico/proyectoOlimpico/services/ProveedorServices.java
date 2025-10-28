package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.model.Proveedor;
import com.olimpico.proyectoOlimpico.repo.ProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorServices {
    private final ProveedorRepository proveedorRepository;

    public ProveedorServices(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    //

    public List<Proveedor> getAllProveedores()
    {
        return proveedorRepository.findAll();
    }

    //

    public Proveedor getByIdProveedor(String id)
    {
        return proveedorRepository.findById(id).orElse(null);
    }

    //

    public Proveedor saveProveedor(Proveedor proveedor)
    {
        return proveedorRepository.save(proveedor);
    }

    //

    public void deleteProveedor(String id)
    {
        proveedorRepository.deleteById(id);
    }
}
