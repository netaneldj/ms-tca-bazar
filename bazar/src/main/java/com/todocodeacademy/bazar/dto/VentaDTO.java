package com.todocodeacademy.bazar.dto;

import com.todocodeacademy.bazar.model.Cliente;
import com.todocodeacademy.bazar.model.Producto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class VentaDTO {
    @NotNull
    private List<Producto> lista_productos;
    @NotNull
    private Cliente un_cliente;

    public VentaDTO() {
    }

    public VentaDTO(List<Producto> lista_productos, Cliente un_cliente) {
        this.lista_productos = lista_productos;
        this.un_cliente = un_cliente;
    }
}
