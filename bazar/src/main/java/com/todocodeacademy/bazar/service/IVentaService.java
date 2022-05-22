package com.todocodeacademy.bazar.service;

import com.todocodeacademy.bazar.dto.ReporteVentasDTO;
import com.todocodeacademy.bazar.model.Producto;
import com.todocodeacademy.bazar.model.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentaService {
    List<Venta> getVentas();

    Venta findVenta(Long id);

    void saveVenta(Venta producto);

    void deleteVenta(Long id);

    void editVenta(Venta producto);

    public boolean availableStock(List<Producto> listaProductos);

    List<Producto> getProductosVenta(Long codigo_venta);

    ReporteVentasDTO getReporteVentas(LocalDate fecha_venta);
}
