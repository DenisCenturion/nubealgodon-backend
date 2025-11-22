package com.nubealgodon.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(unique = true)
    private String email;

    private String password;

    private String rol; // ADMIN, USER

    @Builder.Default
    private Boolean activo = true;

    private LocalDateTime fechaRegistro;

    @OneToOne(mappedBy = "usuario")
    private Carrito carrito;

    @PrePersist
    protected void onCreate() {
        fechaRegistro = LocalDateTime.now();
    }
}
