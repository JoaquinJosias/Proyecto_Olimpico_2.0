package com.olimpico.proyectoOlimpico.model;


import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Marca")
public class Marca {
    @Id
    @Column(name = "id_marca")
    private String id_marca;

    private String nombre_marca;

    private String estado;

    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
    private List<Producto> productos;
}
