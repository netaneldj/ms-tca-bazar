package com.todocodeacademy.bazar.controller;

import com.todocodeacademy.bazar.dto.ClienteDTO;
import com.todocodeacademy.bazar.model.Cliente;
import com.todocodeacademy.bazar.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.todocodeacademy.bazar.utils.ClienteMapper.dtoToCliente;

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
    public ResponseEntity<Cliente> saveCliente(@RequestBody @Valid ClienteDTO dto) {
        Cliente cliente = dtoToCliente(dto);
        service.saveCliente(cliente);
        return new ResponseEntity<Cliente>(cliente, null, HttpStatus.CREATED);
    }

    @DeleteMapping ("/clientes/borrar/{id}")
    public String deleteCliente(@PathVariable Long id) {
        service.deleteCliente(id);
        return "El cliente fue eliminado correctamente";
    }

    @PutMapping ("/clientes/editar/{id}")
    public Cliente editCliente(@PathVariable Long id, @RequestBody @Valid ClienteDTO dto) {
        Cliente cliente = dtoToCliente(dto);
        cliente.setId_cliente(id);
        service.editCliente(cliente);
        return service.findCliente(cliente.getId_cliente());
    }
}
