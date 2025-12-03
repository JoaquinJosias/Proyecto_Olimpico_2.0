package com.olimpico.proyectoOlimpico.services;

import com.olimpico.proyectoOlimpico.DTO.CotizacionDTO;
import com.olimpico.proyectoOlimpico.model.Cotizacion;
import com.olimpico.proyectoOlimpico.repo.CotizacionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CotizacionServiceImpl implements  CotizacionService{

    private final CotizacionRepository cotizacionRepository;

    public CotizacionServiceImpl(CotizacionRepository cotizacionRepository) {
        this.cotizacionRepository = cotizacionRepository;
    }

    @Override
    @Transactional
    public CotizacionDTO crearCotizacion(CotizacionDTO dto) {
        Cotizacion entidad = new Cotizacion();
        entidad.setProveedorCodigo(dto.getIdProveedor());
        entidad.setFecha(dto.getFecha());
        entidad.setVigencia(dto.getVigencia());
        entidad.setSubtotal(dto.getSubtotal());
        entidad.setIgv(dto.getIgv());
        entidad.setTotal(dto.getTotal());

        Cotizacion guardada = cotizacionRepository.save(entidad);
        dto.setIdCotizacion(guardada.getIdCotizacion());
        return dto;
    }
}
