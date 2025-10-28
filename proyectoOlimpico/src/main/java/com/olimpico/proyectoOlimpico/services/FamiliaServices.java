package com.olimpico.proyectoOlimpico.services;


import com.olimpico.proyectoOlimpico.model.Familia;
import com.olimpico.proyectoOlimpico.repo.FamiliaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamiliaServices {
    private final FamiliaRepository familiaRepository;


    public FamiliaServices(FamiliaRepository familiaRepository) {
        this.familiaRepository = familiaRepository;
    }

    //

    public List<Familia> getAllFamilias()
    {
        return familiaRepository.findAll();
    }

    //

    public Familia getFamiliaById(String id)
    {
        return familiaRepository.findById(id).orElse(null);
    }

    //

    public Familia saveFamilia(Familia familia)
    {
        return familiaRepository.save(familia);
    }

    //

    public void deleteFamilia(String id)
    {
        familiaRepository.deleteById(id);
    }
}
