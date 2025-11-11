package com.olimpico.proyectoOlimpico.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "Det_Comprobante")
public class DetComprobante {
    @Id
    @Column(name = "id_detalle")
    private String id_detalle;

    @ManyToOne
    @JoinColumn(name = "id_comprobante", referencedColumnName = "id_comprobante")
    private Comprobante comprobante;

    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    private  Producto producto;

    private String descripcion;

    private int cantidad;

    private BigDecimal precio_unitario;

    private BigDecimal subtotal;
}
