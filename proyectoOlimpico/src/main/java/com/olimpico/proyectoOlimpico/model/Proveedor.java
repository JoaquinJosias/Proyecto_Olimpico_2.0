package com.olimpico.proyectoOlimpico.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private Long id_proveedor;

    private String razon_social;

    private String nombre_comercial;

    private String ruc;

    private String telefono;

    private String email;

    private String direccion;

    private String estado;

    public Proveedor(String razon_social, String nombre_comercial, String ruc, String telefono, String email, String direccion, String estado) {
        this.razon_social = razon_social;
        this.nombre_comercial = nombre_comercial;
        this.ruc = ruc;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.estado = estado;
    }

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.ALL)
    private List<Compra> compras;
}
