package com.olimpico.proyectoOlimpico.controllers;

import com.olimpico.proyectoOlimpico.model.Cargo;
import com.olimpico.proyectoOlimpico.model.Carrito;
import com.olimpico.proyectoOlimpico.services.CarritoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarritoController {

    @Autowired
    private final CarritoServices carritoServices;

    public CarritoController(CarritoServices carritoServices) {
        this.carritoServices = carritoServices;
    }

    @GetMapping("/carritos" )
    public List<Carrito> getAllCarrito() {
        return carritoServices.getAllCarritos();
    }

    @GetMapping("/carritos/{id}" )
    public Carrito getCarritoById(@PathVariable String id) {
        return carritoServices.getCarritoById(id);
    }

    @PostMapping("/carritos")
    public Carrito createCarrito( Carrito carrito) {
        return carritoServices.saveCarrito(carrito);
    }

    @DeleteMapping("/carritos/{id}" )
    public void deleteCarrito(@PathVariable  String id) {
        carritoServices.deleteCarrito(id);
    }
}
