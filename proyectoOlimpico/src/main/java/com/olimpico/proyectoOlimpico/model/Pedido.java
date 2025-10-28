package com.olimpico.proyectoOlimpico.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@Table(name = "Pedido")
public class Pedido {
    @Id
    @Column(name = "id_pedido")
    private String id_pedido;
    private String tipo_comprobante;
    private String tipo_entrega;
    private String direccion_entrega;
    private String estado_pedido;
    private BigDecimal subtotal;
    private BigDecimal igv;
    private BigDecimal total;
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Comprobante comprobante;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<DetPedido> detalles;
}
