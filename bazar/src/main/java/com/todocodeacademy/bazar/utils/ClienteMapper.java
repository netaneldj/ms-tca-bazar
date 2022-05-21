package com.todocodeacademy.bazar.utils;

import com.todocodeacademy.bazar.dto.ClienteDTO;
import com.todocodeacademy.bazar.model.Cliente;

public class ClienteMapper {
    public static Cliente dtoToCliente(ClienteDTO dto){
        Cliente cliente = new Cliente();
        cliente.setNombre(dto.getNombre());
        cliente.setApellido(dto.getApellido());
        cliente.setDni(dto.getDni());
        return cliente;
    }

    public static ClienteDTO clienteToDto(Cliente cliente){
        ClienteDTO dto = new ClienteDTO();
        dto.setNombre(cliente.getNombre());
        dto.setApellido(cliente.getApellido());
        dto.setDni(cliente.getDni());
        return dto;
    }
}
