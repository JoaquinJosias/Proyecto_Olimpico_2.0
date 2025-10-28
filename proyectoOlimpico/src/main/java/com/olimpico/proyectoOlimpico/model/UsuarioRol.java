package com.olimpico.proyectoOlimpico.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "usuario_Rol")
public class UsuarioRol {
    @EmbeddedId
    private UsuarioRolId id;

    @ManyToOne
    @MapsId("idUsuario")
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @MapsId("idRol")
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    private Rol rol;


}
