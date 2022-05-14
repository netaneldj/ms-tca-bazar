package com.todocodeacademy.bazar.controller;

import com.todocodeacademy.bazar.model.Cliente;
import com.todocodeacademy.bazar.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {
    @Autowired
    private IClienteService service;

    @GetMapping("/clientes/traer")
    public List<Cliente> getClientes() {
        return service.getClientes();
    }

    @GetMapping("/clientes/traer/{id}")
    public Cliente getCliente(@PathVariable Long id) {
        return service.findCliente(id);
    }

    @PostMapping("/clientes/crear")
    public String saveCliente(@RequestBody Cliente cliente) {
        service.saveCliente(cliente);
        return "El cliente fue creado correctamente";
    }

    @DeleteMapping ("/clientes/borrar/{id}")
    public String deleteCliente(@PathVariable Long id) {
        service.deleteCliente(id);
        return "El cliente fue eliminado correctamente";
    }

    @PutMapping ("/clientes/editar")
    public Cliente editCliente(@RequestBody Cliente cliente) {
        service.editCliente(cliente);
        return service.findCliente(cliente.getId_cliente());
    }
}
