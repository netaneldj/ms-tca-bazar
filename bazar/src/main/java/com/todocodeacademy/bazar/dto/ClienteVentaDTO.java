package com.todocodeacademy.bazar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteVentaDTO {
    private Long codigo_venta;
    private int cantidad_total_productos;
    private String nombre_cliente;
    private String apellido_cliente;

    public ClienteVentaDTO() {
    }

    public ClienteVentaDTO(Long codigo_venta, int cantidad_total_productos, String nombre_cliente, String apellido_cliente) {
        this.codigo_venta = codigo_venta;
        this.cantidad_total_productos = cantidad_total_productos;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
    }
}
