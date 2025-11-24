package com.olimpico.proyectoOlimpico.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "Usuario", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario {
    @Id
    @Column(name = "id_usuario")
    private String id_usuario;

    private String username;

    private String password_hash;

    private String email;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")


    )
    private Collection<Rol> roles;


    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Cliente cliente;


    public Usuario(String username, String email, String passwordHash, List<Rol> roleUser) {
    }
}
