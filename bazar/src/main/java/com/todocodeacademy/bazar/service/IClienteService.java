package com.todocodeacademy.bazar.service;

import com.todocodeacademy.bazar.model.Cliente;

import java.util.List;

public interface IClienteService {
    List<Cliente> getClientes();

    Cliente findCliente(Long id);

    void editCliente(Cliente cliente);

    void deleteCliente(Long id);

    void saveCliente(Cliente cliente);
}
