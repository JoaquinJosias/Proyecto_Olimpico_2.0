package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.DTO.ClienteDTO;
import com.olimpico.proyectoOlimpico.model.Cliente;
import com.olimpico.proyectoOlimpico.model.Usuario;
import com.olimpico.proyectoOlimpico.repo.ClienteRepository;
import com.olimpico.proyectoOlimpico.repo.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class ClienteServiceImp implements ClienteService {
    private final ClienteRepository clienteRepository;
    private final UsuarioRepository usuarioRepository;


    public ClienteServiceImp(ClienteRepository clienteRepository, UsuarioRepository usuarioRepository) {
        this.clienteRepository = clienteRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Cliente saveOrUpdateProfileByUsuarioId(Long usuarioId, ClienteDTO dto) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        Cliente cliente = clienteRepository.findByUsuario(usuario)
                .orElseGet(Cliente::new);

        cliente.setDni(dto.getDni());
        cliente.setTelefono(dto.getTelefono());
        cliente.setDireccion(dto.getDireccion());
        cliente.setUsuario(usuario);

        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente findByUsuarioId(Long usuarioId) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(usuarioId);
        if (usuarioOpt.isEmpty()) {
            return null;
        }
        return clienteRepository.findByUsuario(usuarioOpt.get()).orElse(null);
    }
}
