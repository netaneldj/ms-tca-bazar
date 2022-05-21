package com.todocodeacademy.bazar.controller;

import com.todocodeacademy.bazar.dto.VentaDTO;
import com.todocodeacademy.bazar.model.Venta;
import com.todocodeacademy.bazar.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.todocodeacademy.bazar.utils.VentaMapper.dtoToVenta;

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
    public Venta saveVenta(@RequestBody @Valid VentaDTO dto) {
        Venta venta = dtoToVenta(dto);
        service.saveVenta(venta);
        return venta;
    }

    @DeleteMapping ("/ventas/borrar/{id}")
    public String deleteVenta(@PathVariable Long id) {
        service.deleteVenta(id);
        return "La venta fue eliminada correctamente";
    }

    @PutMapping ("/ventas/editar/{id}")
    public Venta editVenta(@PathVariable Long id, @RequestBody @Valid VentaDTO dto) {
        Venta venta = dtoToVenta(dto);
        service.editVenta(venta);
        return service.findVenta(venta.getCodigo_venta());
    }
}
