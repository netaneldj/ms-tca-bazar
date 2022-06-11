package com.todocodeacademy.bazar.utils;

import com.todocodeacademy.bazar.dto.ProductoDTO;
import com.todocodeacademy.bazar.model.Producto;

public class ProductoMapper {
    public static Producto dtoToProducto(ProductoDTO dto){
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setMarca(dto.getMarca());
        producto.setCosto(dto.getCosto());
        producto.setCantidad_disponible(dto.getCantidad_disponible());
        return producto;
    }

    public static ProductoDTO productoToDto(Producto producto){
        ProductoDTO dto = new ProductoDTO();
        dto.setNombre(producto.getNombre());
        dto.setMarca(producto.getMarca());
        dto.setCosto(producto.getCosto());
        dto.setCantidad_disponible(producto.getCantidad_disponible());
        return dto;
    }
}
