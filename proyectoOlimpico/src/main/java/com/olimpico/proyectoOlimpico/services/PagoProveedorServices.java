package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.model.Pago_Proveedor;
import com.olimpico.proyectoOlimpico.repo.PagoProveedorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoProveedorServices {
    private final PagoProveedorRepository pagoProveedorRepository;


    public PagoProveedorServices(PagoProveedorRepository pagoProveedorRepository) {
        this.pagoProveedorRepository = pagoProveedorRepository;
    }

    //

    public List<Pago_Proveedor> getAllPagoProveedores()
    {
        return pagoProveedorRepository.findAll();
    }

    //

    public Pago_Proveedor getPagoProveedorById(String id)
    {
        return pagoProveedorRepository.findById(id).orElse(null);
    }

    //

    public Pago_Proveedor savePagoProveedor(Pago_Proveedor pagoProveedor)
    {
        return pagoProveedorRepository.save(pagoProveedor);
    }

    //
    public void deletePagoProveedor(String id)
    {
        pagoProveedorRepository.deleteById(id);
    }
}
