package com.todocodeacademy.bazar.controller;

import com.todocodeacademy.bazar.dto.ClienteVentaDTO;
import com.todocodeacademy.bazar.dto.ReporteVentasDTO;
import com.todocodeacademy.bazar.dto.VentaDTO;
import com.todocodeacademy.bazar.model.Producto;
import com.todocodeacademy.bazar.model.Venta;
import com.todocodeacademy.bazar.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
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

    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<Producto> getProductosVenta(@PathVariable Long codigo_venta) {
        return service.getProductosVenta(codigo_venta);
    }

    @GetMapping("/ventas/{fecha_venta}")
    public ReporteVentasDTO getReporteVentas(@PathVariable("fecha_venta") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate fecha_venta) {
        return service.getReporteVentas(fecha_venta);
    }

    @GetMapping("/ventas/mayor_venta")
    public ClienteVentaDTO getReporteMayorVenta() {
        return service.getReporteMayorVenta();
    }

    @PostMapping("/ventas/crear")
    public Venta saveVenta(@RequestBody @Valid VentaDTO dto) {
        if (!service.availableStock(dto.getListaProductos())) return null;
        Venta venta = dtoToVenta(dto);
        service.saveVenta(venta);
        return service.findVenta(venta.getCodigo_venta());
    }

    @DeleteMapping ("/ventas/borrar/{id}")
    public String deleteVenta(@PathVariable Long id) {
        service.deleteVenta(id);
        return "La venta fue eliminada correctamente";
    }

    @PutMapping ("/ventas/editar/{id}")
    public Venta editVenta(@PathVariable Long id, @RequestBody @Valid VentaDTO dto) {
        Venta venta = dtoToVenta(dto);
        venta.setCodigo_venta(id);
        service.editVenta(venta);
        return service.findVenta(venta.getCodigo_venta());
    }
}
