package com.todocodeacademy.bazar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "cliente")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Cliente {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private Long id_cliente;
    private String nombre;
    private String apellido;
    private String dni;

    @JsonIgnore
    @OneToMany(mappedBy = "un_cliente")
    private List<Venta> lista_ventas_cliente;

    public Cliente() {
    }

    public Cliente(Long id_cliente, String nombre, String apellido, String dni, List<Venta> lista_ventas_cliente) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.lista_ventas_cliente = lista_ventas_cliente;
    }
}
