package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.model.Carrito;
import com.olimpico.proyectoOlimpico.model.Cliente;
import com.olimpico.proyectoOlimpico.repo.CarritoRepository;
import com.olimpico.proyectoOlimpico.repo.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServices {
    private final ClienteRepository clienteRepository;

    public ClienteServices(ClienteRepository clienteRepository)
    {
        this.clienteRepository = clienteRepository;
    }

    //

    public List<Cliente> getAllClientes(){
        return  clienteRepository.findAll();
    }

    public  Cliente getClienteById(String id)
    {
        return  clienteRepository.findById(id).orElse(null);
    }

    public  Cliente saveCliente(Cliente cliente)
    {
        return  clienteRepository.save(cliente);
    }

    public  void deleteCliente(String id)
    {
        clienteRepository.deleteById(id);
    }
}
