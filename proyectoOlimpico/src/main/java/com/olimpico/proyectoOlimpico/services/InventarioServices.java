package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.model.Inventario;
import com.olimpico.proyectoOlimpico.repo.InventarioRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioServices {

    private final InventarioRepository inventarioRepository;


    public InventarioServices(InventarioRepository inventarioRepository) {
        this.inventarioRepository = inventarioRepository;
    }

    //

    public List<Inventario> getAllInventarios()
    {
        return inventarioRepository.findAll();
    }

    //

    public Inventario getInventarioById(String id)
    {
        return inventarioRepository.findById(id).orElse(null);
    }

    //

    public  Inventario saveInventario(Inventario inventario)
    {
        return inventarioRepository.save(inventario);
    }

    //

    public void deleteInventario(String id)
    {
        inventarioRepository.deleteById(id);
    }


}
