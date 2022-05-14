package com.todocodeacademy.bazar.service;

import com.todocodeacademy.bazar.model.Venta;
import com.todocodeacademy.bazar.repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService implements IVentaService{
    @Autowired
    private IVentaRepository repository;

    @Override
    public List<Venta> getVentas() {
        return repository.findAll();
    }

    @Override
    public Venta findVenta(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void saveVenta(Venta venta) {
        repository.save(venta);
    }

    @Override
    public void deleteVenta(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void editVenta(Venta venta) {
        repository.save(venta);
    }
}
