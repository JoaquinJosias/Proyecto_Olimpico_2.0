package com.olimpico.proyectoOlimpico.model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "Cotizacion")
public class Cotizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cotizacion")
    private Long idCotizacion;

    // Guardamos únicamente el identificador/código del proveedor enviado por el cliente
    @Column(name = "proveedor_codigo", length = 50)
    private String proveedorCodigo;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Temporal(TemporalType.DATE)
    private Date vigencia;

    private BigDecimal subtotal;
    private BigDecimal igv;
    private BigDecimal total;
}
