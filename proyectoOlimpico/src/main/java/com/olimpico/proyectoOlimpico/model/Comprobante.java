package com.olimpico.proyectoOlimpico.model;


import com.olimpico.proyectoOlimpico.Enums.MetodoPago;
import com.olimpico.proyectoOlimpico.Enums.TipoComprobante;
import com.olimpico.proyectoOlimpico.Enums.TipoEstado;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "Comprobante")
public class Comprobante {
    @Id
    @Column(name = "id_comprobante")
    private String id_comprobante;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_comprobante", nullable = false)
    private TipoComprobante tipo_comprobante;

    private LocalDateTime fecha_emision;

    private BigDecimal subtotal;

    private BigDecimal igv;

    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    @Column(name = "metodo_pago")
    private MetodoPago metodo_pago;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false)
    private TipoEstado estado;

    private String observaciones;


    @OneToOne
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    private Pedido pedido;

    @OneToMany(mappedBy = "comprobante", cascade = CascadeType.ALL)
    private List<DetComprobante> detComprobantes;








}
