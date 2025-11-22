package com.nubealgodon.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String marca;
    private String modelo;
    private String genero;
    private Integer cantidadDePiezas;
    private String temporada;
    private String composicion;
    private String tipoParteSuperior;
    private String tipoManga;
    private String tipoParteInferior;
    private Double precio;
    private Integer stock;
    private String talle;
    private String descripcion;
    private Boolean enOferta;

    private String imageUrl;

    @ManyToOne
    private Categoria categoria;

    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    @PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDateTime.now();
        fechaActualizacion = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        fechaActualizacion = LocalDateTime.now();
    }
}
