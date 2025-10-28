package com.olimpico.proyectoOlimpico.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Cliente")
public class Cliente {
    @Id
    @Column(name = "id_cliente")
    private String id_cliente;

    private String nombre_cliente;

    private String apellido_cliente;

    private String tipo_documento;

    private String numero_documento;

    private String telefono;

    private String direccion;

    private String estado;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Usuario usuario;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Carrito carrito;
}
