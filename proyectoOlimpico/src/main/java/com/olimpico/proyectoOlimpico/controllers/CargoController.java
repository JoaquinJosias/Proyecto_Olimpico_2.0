package com.olimpico.proyectoOlimpico.controllers;


import com.olimpico.proyectoOlimpico.model.Cargo;
import com.olimpico.proyectoOlimpico.services.CargoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CargoController {

    @Autowired
    private final CargoServices cargoServices;


    public CargoController(CargoServices cargoServices) {
        this.cargoServices = cargoServices;
    }

    @GetMapping("/cargos" )
    public List<Cargo> getAllCargos() {
        return cargoServices.getAllCargos();
    }

    @GetMapping("/cargos/{id}" )
    public Cargo getCargoById(@PathVariable  String id) {
        return cargoServices.getCargoById(id);
    }

    @PostMapping("/cargos")
    public Cargo createCargo( Cargo cargo) {
        return cargoServices.saveCargo(cargo);
    }

    @DeleteMapping("/cargos/{id}" )
    public void deleteCargo(@PathVariable  String id) {
        cargoServices.deleteCargo(id);
    }

}
