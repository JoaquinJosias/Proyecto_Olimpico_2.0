package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.DTO.ProveedorDTO;
import com.olimpico.proyectoOlimpico.model.Proveedor;
import com.olimpico.proyectoOlimpico.repo.ProveedorRepository;
import org.springframework.stereotype.Service;

@Service
public class ProveedorServiceImp implements  ProveedorService{

    private ProveedorRepository proveedorRepository;

    public ProveedorServiceImp(ProveedorRepository proveedorRepository) {
        super();
        this.proveedorRepository = proveedorRepository;
    }

    @Override
    public Proveedor guardarProveedor(ProveedorDTO proveedorDTO) {
        Proveedor proveedor = new Proveedor(
                proveedorDTO.getRazonSocial(),
                proveedorDTO.getNombreComercial(),
                proveedorDTO.getRuc(),
                proveedorDTO.getTelefono(),
                proveedorDTO.getEmail(),
                proveedorDTO.getDireccion(),
                proveedorDTO.getEstado()
                );
        return proveedorRepository.save(proveedor);
    }
}
