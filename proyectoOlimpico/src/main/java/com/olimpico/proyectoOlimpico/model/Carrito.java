package com.olimpico.proyectoOlimpico.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Carrito")
public class Carrito {
    @Id
    @Column(name = "id_carrito")
    private Long id_carrito;

    private String estado;

    @OneToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL)
    private List<DetCarrito> items;
}
