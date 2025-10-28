package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.model.RolPermiso;
import com.olimpico.proyectoOlimpico.model.RolPermisoId;
import com.olimpico.proyectoOlimpico.repo.RolPermisoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolPermisoServices {
    private final RolPermisoRepository rolPermisoRepository;


    public RolPermisoServices(RolPermisoRepository rolPermisoRepository) {
        this.rolPermisoRepository = rolPermisoRepository;
    }

    //

    public List<RolPermiso> getAllRolPemiso()
    {
        return rolPermisoRepository.findAll();
    }

    //

    public RolPermiso getfindByIdRolPermiso(RolPermisoId rolPermisoId)
    {
        return rolPermisoRepository.findById(rolPermisoId).orElse(null);
    }

    //

    public RolPermiso saveRolPermiso(RolPermiso rolPermiso)
    {
        return rolPermisoRepository.save(rolPermiso);
    }

    //

    public void DeleteRolPermiso(RolPermisoId rolPermisoId)
    {
        rolPermisoRepository.deleteById(rolPermisoId);
    }


}
