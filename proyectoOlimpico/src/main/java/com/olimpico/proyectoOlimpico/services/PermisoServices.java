package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.model.Permiso;
import com.olimpico.proyectoOlimpico.repo.PermisoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermisoServices {
    private final PermisoRepository permisoRepository;

    public PermisoServices(PermisoRepository permisoRepository) {
        this.permisoRepository = permisoRepository;
    }

    //

    public List<Permiso> getAllPermiso()
    {
        return permisoRepository.findAll();
    }

    //

    public Permiso getPemisoById(String id)
    {
        return permisoRepository.findById(id).orElse(null);
    }

    //

    public  Permiso savePermiso(Permiso permiso)
    {
        return permisoRepository.save(permiso);
    }

    //

    public void deletePermiso(String id)
    {
        permisoRepository.deleteById(id);
    }

}
