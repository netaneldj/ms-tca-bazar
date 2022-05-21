package com.todocodeacademy.bazar.dto;

import com.todocodeacademy.bazar.model.Cliente;
import com.todocodeacademy.bazar.model.Producto;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class VentaDTO {
    private LocalDate fecha_venta;
    private Double total;
    private List<Producto> listaProductos;
    private Cliente unCliente;
}
