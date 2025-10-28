package com.olimpico.proyectoOlimpico.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @Column(name = "id_usuario")
    private String id_usuario;

    private String username;

    private String password_hash;

    private String email;

    private String estado;

    private LocalDateTime fecha_creacion;

    @OneToOne
    @JoinColumn(name = "id_empleado", referencedColumnName = "id_empleado")
    private  Empleado empleado;

    @OneToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Cliente cliente;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<UsuarioRol> usuarioRols;


}
