package com.olimpico.proyectoOlimpico.model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@Table(name = "Producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long id_producto;

    private String nombre_producto;

    private BigDecimal precio_venta;

    private BigDecimal costo_unitario;

    private int stock_actual;


    private String estado;

    public Producto(int stock_actual, String nombre_producto, BigDecimal precio_venta, BigDecimal costo_unitario, String estado) {
        this.stock_actual = stock_actual;
        this.nombre_producto = nombre_producto;
        this.precio_venta = precio_venta;
        this.costo_unitario = costo_unitario;
        this.estado = estado;
    }

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<DetCarrito> detCarritos;

    @OneToMany(mappedBy = "producto" , cascade = CascadeType.ALL)
    private List<DetInveProd> detallesInventario;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<DetPedido> detallesPedido;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<FacturaCompra> facturaCompras;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<DetComprobante> detComprobantes;
}
