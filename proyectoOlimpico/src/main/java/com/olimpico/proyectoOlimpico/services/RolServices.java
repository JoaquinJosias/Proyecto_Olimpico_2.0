package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.model.Rol;
import com.olimpico.proyectoOlimpico.repo.RolRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServices {

    private final RolRepository rolRepository;

    public RolServices(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    //

    public List<Rol> getAllRoles()
    {
        return  rolRepository.findAll();
    }

    //

    public Rol getByIdRol(String rol)
    {
        return rolRepository.findById(rol).orElse(null);
    }

    //

    public  Rol saveRol(Rol rol)
    {
        return rolRepository.save(rol);
    }

    //

    public void deleteRol(String id)
    {
        rolRepository.deleteById(id);
    }
}
