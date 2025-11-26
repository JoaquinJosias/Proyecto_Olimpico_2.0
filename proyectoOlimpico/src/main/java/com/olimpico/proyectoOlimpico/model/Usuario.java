package com.olimpico.proyectoOlimpico.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties({"password","roles"})
@Table(name = "Usuario", uniqueConstraints = @UniqueConstraint( columnNames= "email"))
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    @Column(name = "nombre")
    private String nombre;
    private String apellido;
    private String password;
    private String email;

    @ManyToMany(fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
    @JoinTable(
            name = "usuario_rol",
            joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "id_rol")
    )
    private Collection<Rol> roles;


    public Usuario(String nombre,String apellido, String email, String password, List<Rol> rolUser) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.roles = rolUser;
    }

}
