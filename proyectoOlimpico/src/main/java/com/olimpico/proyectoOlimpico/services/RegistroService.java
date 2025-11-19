package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.controllers.DTO.RegistroDTO;
import com.olimpico.proyectoOlimpico.model.Cliente;
import com.olimpico.proyectoOlimpico.model.Usuario;
import com.olimpico.proyectoOlimpico.repo.ClienteRepository;
import com.olimpico.proyectoOlimpico.repo.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegistroService {

    private final UsuarioRepository usuarioRepository;
    private final ClienteRepository clienteRepository;

    public void registrarCliente(RegistroDTO dto) throws Exception {

        // VALIDACIONES
        if (usuarioRepository.existsByUsername(dto.getUsername())) {
            throw new Exception("El nombre de usuario ya existe");
        }

        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new Exception("El email ya está registrado");
        }

        // NOMBRE Y APELLIDO
        String[] partes = dto.getNombreCompleto().split(" ", 2);
        String nombre = partes[0];
        String apellido = (partes.length > 1) ? partes[1] : "";

        // CLIENTE
        Cliente cliente = new Cliente();
        cliente.setId_cliente(UUID.randomUUID().toString());
        cliente.setNombre_cliente(dto.getNombreCompleto());
        cliente.setApellido_cliente(""); // tu dto no separa nombres
        cliente.setNumero_documento(dto.getDni());
        cliente.setTelefono(dto.getTelefono());
        cliente.setDireccion(dto.getDireccion());
        cliente.setEstado("ACTIVO");
        clienteRepository.save(cliente);

        // USUARIO
        Usuario usuario = new Usuario();
        usuario.setId_usuario(UUID.randomUUID().toString());
        usuario.setUsername(dto.getUsername());
        usuario.setPassword_hash(dto.getPassword()); // TEXTO PLANO (lo pediste)
        usuario.setEmail(dto.getEmail());
        usuario.setEstado("ACTIVO");
        usuario.setFecha_creacion(LocalDateTime.now());
        usuario.setCliente(cliente); // ← relación
        usuarioRepository.save(usuario);

        // RELACIÓN BIDIRECCIONAL
        usuario.setCliente(cliente);
        cliente.setUsuario(usuario);

        // GUARDAR
        clienteRepository.save(cliente);
        usuarioRepository.save(usuario);
    }
}
