package com.olimpico.proyectoOlimpico.model;

import com.olimpico.proyectoOlimpico.Enums.MetodoPago;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Pago_Proveedor")
public class Pago_Proveedor {
    @Id
    @Column(name = "id_pago")
    private String id_pago;

    @Column(name = "fecha_registro", insertable = false, updatable = false)
    private LocalDateTime fechaRegistro;

    private BigDecimal monto_pago;

    @Enumerated(EnumType.STRING)
    @Column(name = "metodo_pago")
    private MetodoPago metodo_pago;

    private String observaciones;

    private LocalDate fecha_registro;

    @ManyToOne
    @JoinColumn(name = "id_compra", referencedColumnName = "id_compra")
    private Compra compra;


}
