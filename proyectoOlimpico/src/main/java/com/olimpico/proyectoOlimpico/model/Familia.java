package com.olimpico.proyectoOlimpico.model;


import jakarta.persistence.*;
import lombok.Data;

import java.security.PrivateKey;
import java.util.List;

@Data
@Entity
@Table(name = "Familia")
public class Familia {
    @Id
    @Column(name = "id_familia")
    private String id_familia;

    private String nombre_familia;

    private String estado;

    @OneToMany(mappedBy = "familia", cascade = CascadeType.ALL)
    private List<Producto> productos;
}
