package com.nubealgodon.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class CarritoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Carrito carrito;

    @ManyToOne
    private Producto producto;

    private Integer cantidad;

    private Double precioUnitario;

    public Double getSubtotal() {
        return precioUnitario * cantidad;
    }
}
