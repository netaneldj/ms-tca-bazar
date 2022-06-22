package com.todocodeacademy.bazar.controller;

import com.todocodeacademy.bazar.dto.ClienteVentaDTO;
import com.todocodeacademy.bazar.dto.ReporteVentasDTO;
import com.todocodeacademy.bazar.dto.VentaDTO;
import com.todocodeacademy.bazar.model.Producto;
import com.todocodeacademy.bazar.model.Venta;
import com.todocodeacademy.bazar.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Venta> saveVenta(@RequestBody @Valid VentaDTO dto) {
        if (!service.availableStock(dto.getLista_productos())) return null;
        Venta venta = dtoToVenta(dto);
        if (!service.saveVenta(venta)) return new ResponseEntity<Venta>(null, null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<Venta>(service.findVenta(venta.getCodigo_venta()), null, HttpStatus.CREATED);
    }

    @DeleteMapping ("/ventas/borrar/{id}")
    public ResponseEntity<String> deleteVenta(@PathVariable Long id) {
        service.deleteVenta(id);
        return new ResponseEntity<String>("La venta fue eliminada correctamente", null, HttpStatus.OK);
    }

    @PutMapping ("/ventas/editar/{id}")
    public ResponseEntity<Venta> editVenta(@PathVariable Long id, @RequestBody @Valid VentaDTO dto) {
        Venta venta = dtoToVenta(dto);
        venta.setCodigo_venta(id);
        if (!service.editVenta(venta)) return new ResponseEntity<Venta>(null, null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<Venta>(service.findVenta(venta.getCodigo_venta()), null, HttpStatus.OK);
    }
}
