package com.todocodeacademy.bazar.controller;

import com.todocodeacademy.bazar.model.Producto;
import com.todocodeacademy.bazar.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {
    @Autowired
    private IProductoService service;

    @GetMapping("/productos/traer")
    public List<Producto> getProductos() {
        return service.getProductos();
    }

    @GetMapping("/productos/traer/{id}")
    public Producto getProducto(@PathVariable Long id) {
        return service.findProducto(id);
    }

    @PostMapping("/productos/crear")
    public String saveProducto(@RequestBody Producto producto) {
        service.saveProducto(producto);
        return "El producto fue creado correctamente";
    }

    @DeleteMapping ("/productos/borrar/{id}")
    public String deleteProducto(@PathVariable Long id) {
        service.deleteProducto(id);
        return "El producto fue eliminado correctamente";
    }

    @PutMapping ("/productos/editar")
    public Producto editProducto(@RequestBody Producto producto) {
        service.editProducto(producto);
        return service.findProducto(producto.getCodigo_producto());
    }
}
