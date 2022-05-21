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
    private List<Producto> listaProductos;
    @NotNull
    private Cliente unCliente;
}
