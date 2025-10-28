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
    @Column(name = "id_producto")
    private String id_producto;
    private String nombre_producto;
    private BigDecimal precio_venta;
    private BigDecimal costo_unitario;
    private int stock_actual;
    private String unidad_medida;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_familia", referencedColumnName = "id_familia")
    Familia familia;

    @ManyToOne
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca")
    Marca marca;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<DetCarrito> detCarritos;

    @OneToMany(mappedBy = "producto" , cascade = CascadeType.ALL)
    private List<DetInveProd> detallesInventario;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<DetPedido> detallesPedido;

    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private List<DetCompra> detallesCompra;
}
