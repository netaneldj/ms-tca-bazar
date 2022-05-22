package com.todocodeacademy.bazar.service;

import com.todocodeacademy.bazar.model.Producto;
import com.todocodeacademy.bazar.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService implements IProductoService{
    @Autowired
    private IProductoRepository repository;

    @Override
    public List<Producto> getProductos() {
        return repository.findAll();
    }

    @Override
    public Producto findProducto(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void saveProducto(Producto producto) {
        repository.save(producto);
    }

    @Override
    public void deleteProducto(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void editProducto(Producto producto) {
        repository.save(producto);
    }

    @Override
    public List<Producto> getProductosFaltaStock() {
        List<Producto> listFaltaStock = new ArrayList<Producto>();
        for(Producto p : getProductos()){
            if(p.getCantidad_disponible() < 5) listFaltaStock.add(p);
        }
        return listFaltaStock;
    }
}
