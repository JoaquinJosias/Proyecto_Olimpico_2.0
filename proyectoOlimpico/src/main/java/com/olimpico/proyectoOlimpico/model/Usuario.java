package com.olimpico.proyectoOlimpico.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @Column(name = "id_usuario")

    private String id_usuario= UUID.randomUUID().toString();

    private String username;

    private String password_hash;

    private String email;

    private String estado;

    private LocalDateTime fecha_creacion;

    @OneToOne
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    private  Empleado empleado;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Cliente cliente;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<UsuarioRol> usuarioRols;


}
