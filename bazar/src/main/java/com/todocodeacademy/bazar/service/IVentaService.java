package com.todocodeacademy.bazar.service;

import com.todocodeacademy.bazar.model.Venta;

import java.util.List;

public interface IVentaService {
    List<Venta> getVentas();

    Venta findVenta(Long id);

    void saveVenta(Venta producto);

    void deleteVenta(Long id);

    void editVenta(Venta producto);
}
