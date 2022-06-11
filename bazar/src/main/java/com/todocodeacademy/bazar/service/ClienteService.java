package com.todocodeacademy.bazar.service;

import com.todocodeacademy.bazar.model.Cliente;
import com.todocodeacademy.bazar.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService implements IClienteService {
    @Autowired
    private IClienteRepository repository;

    @Override
    public List<Cliente> getClientes() {
        return repository.findAll();
    }

    @Override
    public Cliente findCliente(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void editCliente(Cliente cliente) {
        repository.save(cliente);
    }

    @Override
    public void deleteCliente(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void saveCliente(Cliente cliente) {
        repository.save(cliente);
    }
}
