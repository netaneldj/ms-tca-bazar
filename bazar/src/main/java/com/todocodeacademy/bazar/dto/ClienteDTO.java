package com.todocodeacademy.bazar.dto;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClienteDTO {
    @NotNull
    @NotEmpty
    private String nombre;
    @NotNull
    @NotEmpty
    private String apellido;
    @NotNull
    @NotEmpty
    private String dni;

    public ClienteDTO() {
    }

    public ClienteDTO(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }
}
