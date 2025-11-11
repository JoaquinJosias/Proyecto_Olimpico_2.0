package com.olimpico.proyectoOlimpico.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "Factura_Compra")
public class FacturaCompra {
    @Id
    @Column(name = "id_factura")
    private String id_factura;

    @ManyToOne
    @JoinColumn(name = "id_compra", referencedColumnName = "id_compra")
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    private  Producto producto;

    private int cantidad;

    private BigDecimal precio_unitario;

    private BigDecimal subtotal;

    private LocalDate fecha_vencimiento;

    private String lote;

}
