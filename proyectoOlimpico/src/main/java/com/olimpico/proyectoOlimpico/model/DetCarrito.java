package com.olimpico.proyectoOlimpico.model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "Det_Carrito")
public class DetCarrito {
    @Id
    @Column(name = "id_detalle")
    private String id_detalle;

    @ManyToOne
    @JoinColumn(name = "id_carrito", referencedColumnName = "id_carrito")
    private Carrito carrito;

    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    private Producto producto;

    private int cantidad;

    private BigDecimal precio_unitario;

    @Column(insertable = false, updatable = false)
    private BigDecimal subtotal;


}
