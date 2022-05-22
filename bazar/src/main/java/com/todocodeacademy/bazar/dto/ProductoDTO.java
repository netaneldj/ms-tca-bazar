package com.todocodeacademy.bazar.dto;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProductoDTO {
    @NotNull
    @NotEmpty
    private String nombre;
    @NotNull
    @NotEmpty
    private String marca;
    @NotNull
    private Double costo;
    @NotNull
    private Double cantidad_disponible;

    public ProductoDTO() {
    }

    public ProductoDTO(String nombre, String marca, Double costo, Double cantidad_disponible) {
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidad_disponible = cantidad_disponible;
    }
}
