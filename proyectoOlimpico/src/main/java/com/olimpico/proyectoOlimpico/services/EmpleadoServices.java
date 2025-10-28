package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.model.Empleado;
import com.olimpico.proyectoOlimpico.repo.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoServices {

    private final EmpleadoRepository empleadoRepository;


    public EmpleadoServices(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    //

    public List<Empleado> getAllEmpleados()
    {
        return empleadoRepository.findAll();
    }

    //

    public Empleado getEmpleadoById(String id)
    {
        return empleadoRepository.findById(id).orElse(null);
    }

    //

    public  Empleado saveEmpleado(Empleado empleado)
    {
        return empleadoRepository.save(empleado);
    }

    //

    public void  deleteEmpleado(String id)
    {
        empleadoRepository.deleteById(id);
    }


}
