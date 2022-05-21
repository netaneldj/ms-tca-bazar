package com.todocodeacademy.bazar.utils;

import com.todocodeacademy.bazar.dto.VentaDTO;
import com.todocodeacademy.bazar.model.Venta;

public class VentaMapper {
    public static Venta dtoToVenta(VentaDTO dto){
        Venta venta = new Venta();
        venta.setFecha_venta(dto.getFecha_venta());
        venta.setTotal(dto.getTotal());
        venta.setListaProductos(dto.getListaProductos());
        venta.setUnCliente(dto.getUnCliente());
        return venta;
    }

    public static VentaDTO ventaToDto(Venta venta){
        VentaDTO dto = new VentaDTO();
        dto.setFecha_venta(venta.getFecha_venta());
        dto.setTotal(venta.getTotal());
        dto.setListaProductos(venta.getListaProductos());
        dto.setUnCliente(venta.getUnCliente());
        return dto;
    }
}
