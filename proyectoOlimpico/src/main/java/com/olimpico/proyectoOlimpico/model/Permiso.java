package com.olimpico.proyectoOlimpico.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Permiso")
public class Permiso {
    @Id
    @Column(name = "id_permiso")
    private String id_permiso;

    private String nombre_permiso;

    private String codigo_permiso;

    private String modulo;

    @OneToMany(mappedBy = "permiso", cascade = CascadeType.ALL)
    private List<RolPermiso> rolPermisos;
}
