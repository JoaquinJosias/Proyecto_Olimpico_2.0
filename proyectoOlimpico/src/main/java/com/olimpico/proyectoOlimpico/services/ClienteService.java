package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.DTO.ClienteDTO;
import com.olimpico.proyectoOlimpico.model.Cliente;

public interface ClienteService {
    Cliente saveOrUpdateProfileByUsuarioId(Long usuarioId, ClienteDTO dto);
    Cliente findByUsuarioId(Long usuarioId);
}
