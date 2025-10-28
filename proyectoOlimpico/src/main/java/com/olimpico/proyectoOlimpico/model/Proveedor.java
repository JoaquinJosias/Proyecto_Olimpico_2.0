package com.olimpico.proyectoOlimpico.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Proveedor")
public class Proveedor {
    @Id
    @Column(name = "id_proveedor")
    private String id_proveedor;

    private String razon_social;

    private String nombre_comercial;

    private String ruc;

    private String telefono;

    private String email;

    private String direccion;

    private String estado;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL)
    private List<Compra> compras;
}
