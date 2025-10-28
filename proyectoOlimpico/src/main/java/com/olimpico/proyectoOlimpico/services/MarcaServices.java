package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.model.Marca;
import com.olimpico.proyectoOlimpico.repo.MarcaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaServices {
    private final MarcaRepository marcaRepository;


    public MarcaServices(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }


    //

    public List<Marca> getAllMarcas()
    {
        return marcaRepository.findAll();
    }

    //

    public Marca getMarcaById(String id)
    {
        return marcaRepository.findById(id).orElse(null);
    }

    //

    public Marca saveMarca(Marca marca)
    {
        return marcaRepository.save(marca);
    }

    //

    public void deleteMarca(String id)
    {
        marcaRepository.deleteById(id);
    }


}
