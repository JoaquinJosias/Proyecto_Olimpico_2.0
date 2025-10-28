package com.olimpico.proyectoOlimpico.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@Entity
@Table(name = "Det_Inve_Prod")
public class DetInveProd {
    @EmbeddedId
    private DetInveProdId id;

    @ManyToOne
    @MapsId("idInventario")
    @JoinColumn(name = "id_inventario")
    private Inventario inventario;

    @ManyToOne
    @MapsId("idProducto")
    @JoinColumn(name = "id_producto")
    private Producto producto;

    private String medida_unidad;

    private int cantidad;

    private BigDecimal costo_unitario;

    @Column(insertable = false, updatable = false)
    private  BigDecimal valorInventario;

    private LocalDate fecha_vencimiento;

    private String lote;
}
