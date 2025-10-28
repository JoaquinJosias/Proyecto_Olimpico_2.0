package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.model.Cargo;
import com.olimpico.proyectoOlimpico.repo.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoServices {

    private final CargoRepository cargoRepository;


    public CargoServices(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    //

    public List<Cargo> getAllCargos()
    {
        return  cargoRepository.findAll();
    }

    public  Cargo getCargoById(String id)
    {
        return  cargoRepository.findById(id).orElse(null);
    }

    public  Cargo saveCargo(Cargo cargo)
    {
        return  cargoRepository.save(cargo);
    }

    public  void deleteCargo(String id)
    {
        cargoRepository.deleteById(id);
    }
}
