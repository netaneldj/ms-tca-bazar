package com.todocodeacademy.bazar.controller;

import com.todocodeacademy.bazar.model.Venta;
import com.todocodeacademy.bazar.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VentaController {
    @Autowired
    private IVentaService service;

    @GetMapping("/ventas/traer")
    public List<Venta> getVentas() {
        return service.getVentas();
    }

    @GetMapping("/ventas/traer/{id}")
    public Venta getVenta(@PathVariable Long id) {
        return service.findVenta(id);
    }

    @PostMapping("/ventas/crear")
    public String saveVenta(@RequestBody Venta producto) {
        service.saveVenta(producto);
        return "El producto fue creado correctamente";
    }

    @DeleteMapping ("/ventas/borrar/{id}")
    public String deleteVenta(@PathVariable Long id) {
        service.deleteVenta(id);
        return "El producto fue eliminado correctamente";
    }

    @PutMapping ("/ventas/editar")
    public Venta editVenta(@RequestBody Venta producto) {
        service.editVenta(producto);
        return service.findVenta(producto.getCodigo_venta());
    }
}
