package com.todocodeacademy.bazar.service;

import com.todocodeacademy.bazar.dto.ClienteVentaDTO;
import com.todocodeacademy.bazar.dto.ReporteVentasDTO;
import com.todocodeacademy.bazar.model.Producto;
import com.todocodeacademy.bazar.model.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    List<Venta> getVentas();

    Venta findVenta(Long id);

    boolean saveVenta(Venta producto);

    void deleteVenta(Long id);

    boolean editVenta(Venta producto);

    public boolean availableStock(List<Producto> listaProductos);

    List<Producto> getProductosVenta(Long codigo_venta);

    ReporteVentasDTO getReporteVentas(LocalDate fecha_venta);

    ClienteVentaDTO getReporteMayorVenta();
}
