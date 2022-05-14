package com.todocodeacademy.bazar.service;

import com.todocodeacademy.bazar.model.Producto;

import java.util.List;

public interface IProductoService {
    List<Producto> getProductos();

    Producto findProducto(Long id);

    void saveProducto(Producto producto);

    void deleteProducto(Long id);

    void editProducto(Producto producto);
}
