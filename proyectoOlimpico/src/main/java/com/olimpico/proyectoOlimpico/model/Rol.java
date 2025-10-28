package com.olimpico.proyectoOlimpico.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Rol")
public class Rol {
    @Id
    @Column(name = "id_rol")
    private String id_rol;

    private String nombre_rol;

    private String descripcion;

    private int nivel_acceso;

    private String estado;


    @OneToMany(mappedBy = "rol" , cascade = CascadeType.ALL)
    private List<RolPermiso> rolPermisos;

    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
    private List<UsuarioRol> usuariosRols;
}
