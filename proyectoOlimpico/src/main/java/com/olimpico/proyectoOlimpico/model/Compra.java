package com.olimpico.proyectoOlimpico.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "Compra")
public class Compra {
    @Id
    @Column(name = "id_compra")
    private String id_compra;

    private String numero_comprobante;

    private String tipo_comprobante;

    private LocalDate fecha_compra;

    private BigDecimal subtotal;

    private BigDecimal igv;

    private  BigDecimal total;

    private String estado_compra;

    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor")
    Proveedor proveedor;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    private List<Pago_Proveedor> pagoProveedores;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)
    private List<DetCompra> detallesCompra;


}
