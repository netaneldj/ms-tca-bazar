package com.todocodeacademy.bazar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReporteVentasDTO {
    private Double monto;
    private int cantidad_total_ventas;

    public ReporteVentasDTO() {
    }

    public ReporteVentasDTO(Double monto, int cantidad_total_ventas) {
        this.monto = monto;
        this.cantidad_total_ventas = cantidad_total_ventas;
    }
}
