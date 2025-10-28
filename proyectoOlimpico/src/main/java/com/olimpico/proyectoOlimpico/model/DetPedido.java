package com.olimpico.proyectoOlimpico.model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "Det_Pedido")
public class DetPedido {
    @Id
    @Column(name = "id_detalle")
    private String id_detalle;

    @ManyToOne
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    private Producto producto;

    private int cantidad;

    private BigDecimal precio_unitario;

    private BigDecimal subtotal;

    private String observaciones;
}
