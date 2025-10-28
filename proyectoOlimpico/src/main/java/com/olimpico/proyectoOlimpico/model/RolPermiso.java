package com.olimpico.proyectoOlimpico.model;


import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Rol_Permiso")
public class RolPermiso {
    @EmbeddedId
    private RolPermisoId id;

    @ManyToOne
    @MapsId("idRol")
    @JoinColumn(name = "id_rol")
    private Rol rol;

    @ManyToOne
    @MapsId("idPermiso")
    @JoinColumn(name = "id_permiso")
    private Permiso permiso;

    @Column(name = "fecha_asignacion", columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime fechaAsignacion;
}
