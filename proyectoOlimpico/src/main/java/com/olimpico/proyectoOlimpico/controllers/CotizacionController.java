package com.olimpico.proyectoOlimpico.controllers;

import com.olimpico.proyectoOlimpico.DTO.CotizacionDTO;
import com.olimpico.proyectoOlimpico.services.CotizacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cotizaciones")
@RequiredArgsConstructor
public class CotizacionController {

    private final CotizacionService cotizacionService;

    @PostMapping
    public ResponseEntity<CotizacionDTO> crear(@RequestBody CotizacionDTO dto) {
        CotizacionDTO guardada = cotizacionService.crearCotizacion(dto);
        return ResponseEntity.status(201).body(guardada);
    }
}
