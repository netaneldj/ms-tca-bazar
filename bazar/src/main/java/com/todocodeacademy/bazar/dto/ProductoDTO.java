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
}
