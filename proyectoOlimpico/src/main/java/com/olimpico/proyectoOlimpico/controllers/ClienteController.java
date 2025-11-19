package com.olimpico.proyectoOlimpico.controllers;


import com.olimpico.proyectoOlimpico.model.Cliente;
import com.olimpico.proyectoOlimpico.services.ClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {
    @Autowired
    private final ClienteServices clienteServices;

    public ClienteController(ClienteServices clienteServices) {
        this.clienteServices = clienteServices;
    }

    @GetMapping("/clientes")
    public List<Cliente> getAllClientes() {
        return clienteServices.getAllClientes();
    }

    @GetMapping("/clientes/{id}" )
    public Cliente getClienteById(@PathVariable String id) {
        return clienteServices.getClienteById(id);
    }

    @PostMapping("/clientes")
    public Cliente createCliente( Cliente cliente) {
        return clienteServices.saveCliente(cliente);
    }

    @DeleteMapping("/clientes/{id}" )
    public void deleteCliente(@PathVariable  String id) {
        clienteServices.deleteCliente(id);
    }

}
